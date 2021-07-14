package com.myblog.myblogproject.util.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SignupExceptionHandler {

    @ExceptionHandler(value = {SignupRequestException.class})
    public String handleApiRequestException(SignupRequestException ex, Model model) {

        model.addAttribute("signupFail", ex.getMessage());

        return "/user/signup";
    }
}