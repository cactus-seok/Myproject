package com.myblog.myblogproject.domain;

import com.myblog.myblogproject.dto.KakaoSignupRequestDto;
import com.myblog.myblogproject.dto.SignupRequestDto;
import com.myblog.myblogproject.util.UserValidate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class User extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private Long kakaoId;

    // 일반 유저 생성
    public User(SignupRequestDto signupRequestDto) {
        UserValidate.checkName(signupRequestDto);
        UserValidate.checkPassword(signupRequestDto);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); //암호화

        this.username = signupRequestDto.getUsername();
        this.password = encoder.encode(signupRequestDto.getPassword());
        this.kakaoId = null;
    }

    // 카카오로그인 유저 생성
    public User(KakaoSignupRequestDto kakaoSignupRequestDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); //암호화

        this.username = kakaoSignupRequestDto.getUsername();
        this.password = encoder.encode(kakaoSignupRequestDto.getPassword());
        this.kakaoId = kakaoSignupRequestDto.getKakaoId();
    }
}