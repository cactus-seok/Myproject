package com.myblog.myblogproject.service;

import com.myblog.myblogproject.domain.Post;
import com.myblog.myblogproject.dto.PostDetailResponseDto;
import com.myblog.myblogproject.dto.PostRequestDto;
import com.myblog.myblogproject.dto.PostSimpleResponseDto;
import com.myblog.myblogproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    //포스트 생성
    @Transactional
    public Long save(PostRequestDto requestDto){
        Post post = new Post(requestDto);
        return postRepository.save(post).getId();
    }

    //포스트 삭제
    @Transactional
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
    // 게시글 리스트 불러오기
    @Transactional
    public List<PostSimpleResponseDto> findAll(){
        return postRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(post -> new PostSimpleResponseDto(post))
                .collect(Collectors.toList());
        // postsRepository.findAll()는 List<Post>를 반환하는데
        // 이를 List<PostSimpleResponseDto>로 바꿔서 반환
    }

    // 게시글 상세 조회
    @Transactional
    public PostDetailResponseDto findById(Long id){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        return new PostDetailResponseDto(post);
    }

    // 포스트 수정
    @Transactional
    public Long update(Long id, PostRequestDto requestDto){
        Post product = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        product.update(requestDto);
        return id;
    }


}
