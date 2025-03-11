package com.intellibus.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intellibus.api.dto.user.AuthRequestDto;
import com.intellibus.api.dto.user.UserResponseDto;
import com.intellibus.api.models.User;
import com.intellibus.api.repositories.UserRepository;
import com.intellibus.api.services.interfaces.IUserService;
import com.intellibus.api.services.interfaces.UserMapper;
import com.intellibus.api.util.AuthUtil;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthUtil authUtil;

    @Override
    public String authenticate(AuthRequestDto authRequestDto) throws Exception {
        var user = userRepository.findByUsername(authRequestDto.getUsername());
        if(user == null || !authUtil.verifyPassword(authRequestDto.getPassword(), user.getPassword())){
            throw new Exception("Invalid username or password");
        }

        return authUtil.generateToken(authRequestDto.getUsername());
    }

    @Override
    public UserResponseDto register(User user) {
        user.setPassword(authUtil.encryptPassword(user.getPassword()));
        userRepository.save(user);
        UserResponseDto registerResponseDto = UserMapper.INSTANCE.userToRegisterResponseDto(user);
        return registerResponseDto;
    }

    @Override
    public UserResponseDto fetchUser(String username) throws Exception {
        var user = userRepository.findByUsername(username);
        if(user == null){
            throw new Exception("User Not found.");
        }

        return UserMapper.INSTANCE.userToRegisterResponseDto(user);
    }
    
}
