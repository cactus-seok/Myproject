package com.myblog.myblogproject.dto;

import com.myblog.myblogproject.domain.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostSimpleResponseDto {
    private final Long id;
    private final String title;
    private final String username;
    private final LocalDateTime createdAt;

    public PostSimpleResponseDto(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.username = post.getUsername();
        this.createdAt = post.getCreatedAt();
    }
}
