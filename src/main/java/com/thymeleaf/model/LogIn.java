package com.thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LogIn {
    @NotBlank(message = "Username cannot be empty")
    @Size(min = 3,max = 12, message = "Username must be between 3 to 12 characters")
    private String userName;
    private String email;
}
