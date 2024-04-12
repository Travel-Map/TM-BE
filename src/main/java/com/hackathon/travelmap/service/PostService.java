package com.hackathon.travelmap.service;

import com.hackathon.travelmap.domain.Post;
import com.hackathon.travelmap.domain.Region;
import com.hackathon.travelmap.domain.User;
import com.hackathon.travelmap.dto.requestDto.CreatePostRequestDto;
import com.hackathon.travelmap.dto.responseDto.SinglePostDetailResponseDto;
import com.hackathon.travelmap.repository.PostRepository;
import com.hackathon.travelmap.repository.RegionRepository;
import com.hackathon.travelmap.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final RegionRepository regionRepository;
    private final UserRepository userRepository;

    /**
     * 단일 포스트 상세페이지 제공
     * @param postId
     * @return
     */
    public SinglePostDetailResponseDto findSinglePostDetail(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("게시물을 찾을 수 없습니다."));
        return SinglePostDetailResponseDto.of(post);
    }

    /**
     * 포스트 생성 기능
     * @param createPostRequestDto
     */
    @Transactional
    public void createPost(CreatePostRequestDto createPostRequestDto) {

        // Login 기능이 없어 Security Context를 사용이 불가 -> 고정 user로 넣어줘서 구현 -> 후에 변경이 필요
        User user = userRepository.findById(1l).orElseThrow(() -> new RuntimeException("id에 맞는 User를 찾을 수 없습니다."));
        Region region = regionRepository.findById(createPostRequestDto.getRegionId()).orElseThrow(() ->  new RuntimeException("id에 맞는 Region을 찾을 수 없습니다."));

        Post post = createPostRequestDto.toPost(user, region);
        postRepository.save(post);
    }
}
