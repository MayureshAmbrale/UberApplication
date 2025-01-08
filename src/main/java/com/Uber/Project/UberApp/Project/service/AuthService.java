package com.Uber.Project.UberApp.Project.service;

import com.Uber.Project.UberApp.Project.dto.DriverDto;
import com.Uber.Project.UberApp.Project.dto.SignupDto;
import com.Uber.Project.UberApp.Project.dto.UserDto;
import org.springframework.stereotype.Service;

public interface AuthService {

    String[] login(String email, String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onboardNewDriver(Long userId, String vehicleId);
    String refreshToken(String token);
}
