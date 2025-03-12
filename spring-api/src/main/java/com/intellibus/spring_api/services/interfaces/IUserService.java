package com.intellibus.spring_api.services.interfaces;

import com.intellibus.spring_api.dto.user.AuthRequestDto;
import com.intellibus.spring_api.dto.user.UserResponseDto;
import com.intellibus.spring_api.models.User;

public interface IUserService {
    public String authenticate(AuthRequestDto authRequestDto) throws Exception;
    public UserResponseDto register(User user);
    public UserResponseDto fetchUser(String username) throws Exception;
}
