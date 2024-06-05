package com.teaching.teaching.controllers;

import com.teaching.teaching.TeachingApplication;
import com.teaching.teaching.dto.SigninRequest;
import com.teaching.teaching.dto.SignupRequest;
import com.teaching.teaching.security.JwtCore;
import com.teaching.teaching.service.UserDetailsServiceImpl;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.Objects;

import static java.rmi.server.LogStream.log;


@RestController
@Slf4j
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:8080")
public class SecurityController {

    private final UserDetailsServiceImpl userService;

    @Autowired
    public SecurityController(UserDetailsServiceImpl userService) {
        this.userService = userService;
    }
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtCore jwtCore;

    @PostMapping("/signup")
    ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        // Check if the username is empty
        if (signupRequest.getUserName() == null || signupRequest.getUserName().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Имя пользователя не может быть пустым");
        }// Check if the username is empty
        if (signupRequest.getPassword() == null || signupRequest.getPassword().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Пароль пользователя не может быть пустым");
        }
        String serviceResult = userService.newUser(signupRequest);
        if (serviceResult == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка при обработке запроса");
        }
        if (Objects.equals(serviceResult, "Выберите другое имя")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResult);
        }
        return ResponseEntity.ok("Вы успешно зарегистрированы. Теперь можете войти в свой аккаунт.");
    }

    @PostMapping("/signin")
    ResponseEntity<?> signin(@RequestBody SigninRequest signinRequest) {

        UserDetails user = userService.loadUserByUsername(signinRequest.getUserName());
        String hashedPassword = passwordEncoder.encode(signinRequest.getPassword());
        if (!Objects.equals(user.getUsername(), signinRequest.getUserName())) {
            SecurityController.log.info("Имя пользователя пустое " + signinRequest.getUserName());
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if (Objects.equals(user, null) || !passwordEncoder.matches(signinRequest.getPassword(), user.getPassword())) {
            SecurityController.log.info("Ошибка авторизации пользователя " + signinRequest.getUserName());
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        String jwt = jwtCore.generateToken(user);

        TeachingApplication.currentUser = userService.loadUserEntityByUsername(signinRequest.getUserName());
        SecurityController.log.info("Вход прошёл успешно");
        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
        // Clear the authentication
        SecurityContextHolder.clearContext();

        // Invalidate the session if it exists
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        TeachingApplication.currentUser = null;
        //token expiration TODO

        return ResponseEntity.ok("Logged out successfully");
    }
}
