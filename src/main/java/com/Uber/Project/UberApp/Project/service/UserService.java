package com.Uber.Project.UberApp.Project.service;

import com.Uber.Project.UberApp.Project.entity.User;
import com.Uber.Project.UberApp.Project.exception.ResourceNotFoundException;
import com.Uber.Project.UberApp.Project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public User getUserById(Long userId) {
        return userRepository.getUserById(userId).orElseThrow(() -> new ResourceNotFoundException("No user found with userId :"+userId));
    }
}
