package com.hackathon.travelmap.controller;

import com.hackathon.travelmap.dto.responseDto.SinglePostDetailResponseDto;
import com.hackathon.travelmap.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
