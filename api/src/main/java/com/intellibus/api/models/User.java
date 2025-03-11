package com.intellibus.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First Name is required.")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "Last Name is required.")
    @Column(nullable = false)
    private String lastName;

    @NotBlank(message = "Username is required.")
    @Column(nullable = false)
    private String username;

    @NotBlank(message = "Password is required.")
    @Column(nullable = false)
    private String password;

    @Min(value = 10, message = "You must be atleast 10 Years old to register.")
    @NotNull(message = "Age is required.")
    @Column(nullable = false)
    private Integer age;

    @NotBlank(message = "Gender is required.")
    @Column(nullable = false)
    private String gender;
}
