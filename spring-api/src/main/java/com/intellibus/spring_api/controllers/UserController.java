package com.intellibus.spring_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intellibus.spring_api.dto.user.AuthRequestDto;
import com.intellibus.spring_api.dto.user.UserResponseDto;
import com.intellibus.spring_api.models.User;
import com.intellibus.spring_api.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@RequestMapping(value = "/api/users/")
@Tag(name = "User API", description = "Operations related to users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/authenticate")
    @Operation(summary = "Authenticate", description = "Returns a bearer token.")
    public ResponseEntity<Object> authenticate(@Valid @RequestBody AuthRequestDto authDto) {
        
        try {
            var token = userService.authenticate(authDto);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        
    }

    @PostMapping("/register")
    @Operation(summary = "User Registration", description = "Register a user")
    public ResponseEntity<Object> register(@Valid @RequestBody User user) {
        
        UserResponseDto registeredUser = userService.register(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @GetMapping("/fetchUser")
    @Operation(summary = "Get user by usernaname", description = "Returns a user based on the provided username")
    @ApiResponse(responseCode = "200", description = "User found")
    @ApiResponse(responseCode = "404", description = "User not found")
    public ResponseEntity<Object> fetchUser(@RequestParam(required = true) String username) {
        try{
            var user = userService.fetchUser(username);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
}
