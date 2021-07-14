package com.myblog.myblogproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class KakaoSignupRequestDto {
    private String username;
    private String password;
    private Long kakaoId;
}