package com.intellibus.spring_api.services.interfaces;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.intellibus.spring_api.dto.user.UserResponseDto;
import com.intellibus.spring_api.models.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseDto userToRegisterResponseDto(User user);
}
