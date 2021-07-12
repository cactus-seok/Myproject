package com.myblog.myblogproject.controller;

import com.myblog.myblogproject.dto.PostDetailResponseDto;
import com.myblog.myblogproject.dto.PostRequestDto;
import com.myblog.myblogproject.dto.PostSimpleResponseDto;

import com.myblog.myblogproject.service.PostService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    //게시글 등록
    @PostMapping("/api/post")
    public Long saveNewPost(@RequestBody PostRequestDto requestDto) {
        return postService.save(requestDto);
    }

    //게시글 목록 조회
    @GetMapping("/api/post")
    public List<PostSimpleResponseDto> getPostList() {
        return postService.findAll();
    }

    //특정 게시글 조회
    @GetMapping("/api/post/{id}")
    public PostDetailResponseDto getPost(@PathVariable Long id) {
        return postService.findById(id);
    }

    // 특정 게시글 삭제
//    @DeleteMapping("/api/posts/{id}")
//    public Long deletePost(@PathVariable Long id){
//        postService.delete(id);
//        return id;
//    }

    // 특정 게시글 수정
    @PutMapping("/api/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.update(id, requestDto);
    }


}
