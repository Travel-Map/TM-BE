package com.hackathon.travelmap.service;

import com.hackathon.travelmap.domain.Post;
import com.hackathon.travelmap.dto.responseDto.SinglePostDetailResponseDto;
import com.hackathon.travelmap.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    public SinglePostDetailResponseDto findSinglePostDetail(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("게시물을 찾을 수 없습니다."));
        return SinglePostDetailResponseDto.of(post);
    }
}
