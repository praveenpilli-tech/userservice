package com.mpro.userservice.controller;

import com.mpro.userservice.common.ApiResponse;
import com.mpro.userservice.dto.AuthRequest;
import com.mpro.userservice.dto.AuthResponse;
import com.mpro.userservice.dto.RegisterRequestDto;
import com.mpro.userservice.dto.RegisterResponseDto;
import com.mpro.userservice.service.UserService;
import com.mpro.userservice.util.JwtUtil;
import com.mpro.userservice.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private static final Logger log = LogManager.getLogger(UserController.class);

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<RegisterResponseDto>> createUser(@RequestBody RegisterRequestDto requestDto){

        log.info("UserService logging initialized successfully");

        log.info("Received request to create user with email {}",requestDto.getEmail());
        log.debug("User request payload : "+requestDto.getEmail()+" : "+requestDto.getUsername());
        RegisterResponseDto responseDto = userService.createUser(requestDto);
        return ResponseUtil.created("User created successfully",responseDto);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@RequestBody AuthRequest request){
        log.info("Login method called : ",getClass());
         String token = jwtUtil.generateToken(request.getUsername());
         return ResponseUtil.created("token generated successfully",new AuthResponse(token));

    }

    @GetMapping("/about")
    public ResponseEntity<ApiResponse<String>> about(){
        log.info("logging about method in controller class");
        return ResponseUtil.success("About method called in usercontroller","tulasi");
    }

    @GetMapping("/flipkart")
    public ResponseEntity<ApiResponse<String>> flipkart(){
        return ResponseUtil.success("Flipkart interface is opened", "Flipkart.com");
    }
}
