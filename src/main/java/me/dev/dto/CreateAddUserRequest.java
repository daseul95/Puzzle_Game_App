package me.dev.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateAddUserRequest {
    private String email;
    private String password;
}