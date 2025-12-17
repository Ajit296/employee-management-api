package com.ajit.employee_management.controller;

import com.ajit.employee_management.dto.AuthRequest;
import com.ajit.employee_management.dto.AuthResponse;
import com.ajit.employee_management.dto.RegisterRequest;
import com.ajit.employee_management.entity.Users;
import com.ajit.employee_management.repository.UserRepository;
import com.ajit.employee_management.utility.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    UserRepository userRepo;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest){

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword())
        );

          String token  = jwtUtil.generateToken(authRequest.getUsername());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request){

        if(userRepo.existsByUsername(request.getUsername())) {
            throw new RuntimeException("User Already Exist");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPass  = encoder.encode(request.getPassword());
        Users newUser = new Users();
        newUser.setRole("USER");
        newUser.setUsername(request.getUsername());
        newUser.setPassword(encodedPass);
        userRepo.save(newUser);
        return "Register Successfully";
    }
}
