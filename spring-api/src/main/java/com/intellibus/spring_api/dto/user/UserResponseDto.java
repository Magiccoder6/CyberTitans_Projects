package com.intellibus.spring_api.dto.user;

import lombok.Data;

@Data
public class UserResponseDto {
    private String firstName;
    private String lastName;
    private String username;
    private Integer age;
    private String gender;
}
