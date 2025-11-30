package com.mpro.userservice.service;

import com.mpro.userservice.dto.RegisterRequestDto;
import com.mpro.userservice.dto.RegisterResponseDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    RegisterResponseDto createUser(RegisterRequestDto requestDto);

    RegisterResponseDto getUserById(UUID id);

    List<RegisterResponseDto> getAllUsers();

    RegisterResponseDto updateUser(UUID id, RegisterRequestDto requestDto);

    void deleteUser(UUID id);
}
