package com.myblog.myblogproject.controller;

import com.myblog.myblogproject.dto.SignupRequestDto;
import com.myblog.myblogproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    //회원가입화면
    @GetMapping("/signup")
    public void signup(){
    }

    //회원가입처리
    @PostMapping("/signup")
    public String registerUser(SignupRequestDto signupRequestDto){
        userService.registerUser(signupRequestDto);
        return "redirect:/login";
    }

    // 회원 로그인 페이지
    @GetMapping("/login")
    public void login() { }

    @GetMapping("/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "/login";
    }

    @GetMapping("/login/forbidden")
    public String forbidden(Model model) {
        model.addAttribute("forbidden", true);
        return "/login";
    }

}
