package com.hackathon.travelmap.controller;

import com.hackathon.travelmap.dto.requestDto.CreatePostRequestDto;
import com.hackathon.travelmap.dto.responseDto.PostCardItemResponseDto;
import com.hackathon.travelmap.dto.responseDto.SinglePostDetailResponseDto;
import com.hackathon.travelmap.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    /**
     * 단일 포스트 페이지 제공 API
     * @param postId
     * @return 단일 포스팅 페이지를 위한 데이터
     */
    @GetMapping("/detail/{postId}")
    public ResponseEntity<SinglePostDetailResponseDto> getSinglePostDetail(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.findSinglePostDetail(postId));
    }

    /**
     * 유저의 전체 블로그 리스트 반환 (사용자 Id를 1로 고정한 상태)
     * @return 전체 블로그 리스트
     */
    @GetMapping("/list")
    public ResponseEntity<List<PostCardItemResponseDto>> getAllCardItems() {
        return ResponseEntity.ok(postService.findAllCardItemsByUser());
    }

    /**
     * 포스트 생성
     * @param createPostRequestDto
     * @return nothing
     */
    @PostMapping("/write")
    public ResponseEntity<Void> createPost(@RequestBody CreatePostRequestDto createPostRequestDto) {
        postService.createPost(createPostRequestDto);
        return ResponseEntity.noContent().build();
    }
}
