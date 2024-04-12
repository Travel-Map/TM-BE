package com.hackathon.travelmap.controller;

import com.hackathon.travelmap.dto.responseDto.SinglePostDetailResponseDto;
import com.hackathon.travelmap.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/detail/{postId}")
    public ResponseEntity<SinglePostDetailResponseDto> getSinglePostDetail(@PathVariable Long postId) {
        try {
            return ResponseEntity.ok(postService.findSinglePostDetail(postId));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            throw e;
        }
    }
}
