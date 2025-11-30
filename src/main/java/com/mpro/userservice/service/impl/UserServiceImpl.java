package com.mpro.userservice.service.impl;

import com.mpro.userservice.dto.RegisterRequestDto;
import com.mpro.userservice.dto.RegisterResponseDto;
import com.mpro.userservice.model.User;
import com.mpro.userservice.repository.UserRepository;
import com.mpro.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private RegisterResponseDto toDto(User user){
        return new RegisterResponseDto(user.getId(),user.getUsername(),user.getEmail());
    }

    private User toEntity(RegisterRequestDto requestDto){
        User user = new User();
        user.setUsername(requestDto.getUsername());
        user.setEmail(requestDto.getEmail());
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        return user;
    }

    @Override
    public RegisterResponseDto createUser(RegisterRequestDto requestDto) {
        User savedUser = userRepository.save(toEntity(requestDto));
        return toDto(savedUser);
    }

    @Override
    public RegisterResponseDto getUserById(UUID id) {
        return null;
    }

    @Override
    public List<RegisterResponseDto> getAllUsers() {
        return List.of();
    }

    @Override
    public RegisterResponseDto updateUser(UUID id, RegisterRequestDto requestDto) {
        return null;
    }

    @Override
    public void deleteUser(UUID id) {

    }
}
