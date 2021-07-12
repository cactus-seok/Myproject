package com.myblog.myblogproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class PostRequestDto {
    private final String title;
    private final String username;
    private final String contents;
}
