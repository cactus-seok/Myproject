package com.myblog.myblogproject.repository;

import com.myblog.myblogproject.domain.Post;
import com.myblog.myblogproject.dto.PostRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    //save(),  findAll() 테스트
    @Test
    @DisplayName("Post 저장 후 읽기")
    public void saveAndRead(){
        //given
        String title = "TestTitle";
        String username = "TestUsername";
        String contents = "TestContents";

        PostRequestDto requestDto = new PostRequestDto(
                title,
                username,
                contents
        );

        Post post = new Post(requestDto);
        postRepository.save(post);

        //when
        List<Post> postList = postRepository.findAll();

        //then
        Post posts = postList.get(0);
        System.out.println(posts.getId());
        System.out.println(posts.getTitle());
        System.out.println(posts.getUsername());
        System.out.println(posts.getContents());
        assertEquals(posts.getTitle(), title);

    }

}