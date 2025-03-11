package com.intellibus.api.services.interfaces;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.intellibus.api.dto.user.UserResponseDto;
import com.intellibus.api.models.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseDto userToRegisterResponseDto(User user);
}
