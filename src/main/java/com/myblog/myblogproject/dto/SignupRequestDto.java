package com.myblog.myblogproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {
    private String Username;
    private String Password;
    private String PasswordCheck;
    private String email;
}
