package com.intellibus.api.services.interfaces;

import com.intellibus.api.dto.user.AuthRequestDto;
import com.intellibus.api.dto.user.UserResponseDto;
import com.intellibus.api.models.User;

public interface IUserService {
    public String authenticate(AuthRequestDto authRequestDto) throws Exception;
    public UserResponseDto register(User user);
    public UserResponseDto fetchUser(String username) throws Exception;
}
