package com.Uber.Project.UberApp.Project.service.impl;

import com.Uber.Project.UberApp.Project.dto.DriverDto;
import com.Uber.Project.UberApp.Project.dto.SignupDto;
import com.Uber.Project.UberApp.Project.dto.UserDto;
import com.Uber.Project.UberApp.Project.entity.Driver;
import com.Uber.Project.UberApp.Project.entity.User;
import com.Uber.Project.UberApp.Project.entity.enums.Role;
import com.Uber.Project.UberApp.Project.exception.ResourceNotFoundException;
import com.Uber.Project.UberApp.Project.exception.RuntimeConflictException;
import com.Uber.Project.UberApp.Project.repository.UserRepository;
import com.Uber.Project.UberApp.Project.service.AuthService;
import com.Uber.Project.UberApp.Project.service.DriverService;
import com.Uber.Project.UberApp.Project.service.RiderService;
import com.Uber.Project.UberApp.Project.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static com.Uber.Project.UberApp.Project.entity.enums.Role.DRIVER;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RiderService riderService;
    private final WalletService walletService;
    private final DriverService driverService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String[] login(String email, String password) {

        String tokens[] = new String[2];

        return tokens;
    }

    @Override
    @Transactional
    public UserDto signup(SignupDto signupDto) {
        User user = userRepository.findByEmail(signupDto.getEmail()).orElse(null);
        if(user != null)
            throw new RuntimeConflictException("Cannot signup, User already exists with email "+signupDto.getEmail());

        User mappedUser = modelMapper.map(signupDto, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        mappedUser.setPassword(passwordEncoder.encode(mappedUser.getPassword()));
        User savedUser = userRepository.save(mappedUser);

//        create user related entities
        riderService.createNewRider(savedUser);
        walletService.createNewWallet(savedUser);

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(Long userId, String vehicleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id "+userId));

        if(user.getRoles().contains(DRIVER))
            throw new RuntimeConflictException("User with id "+userId+" is already a Driver");

        Driver createDriver = Driver.builder()
                .user(user)
                .rating(0.0)
                .vehicleId(vehicleId)
                .available(true)
                .build();
        user.getRoles().add(DRIVER);
        userRepository.save(user);
        Driver savedDriver = driverService.createNewDriver(createDriver);
        return modelMapper.map(savedDriver, DriverDto.class);
    }
}


