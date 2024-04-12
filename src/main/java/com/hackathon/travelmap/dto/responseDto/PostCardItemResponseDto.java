package com.hackathon.travelmap.dto.responseDto;

import com.hackathon.travelmap.domain.Post;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostCardItemResponseDto {
    private String title;
    private List<String> travelImages;
    private LocalDate writeAt;
    private int likeCount;

    public static PostCardItemResponseDto of(Post post) {
        return new PostCardItemResponseDto(
            post.getTitle(),
            post.getTravelImages(),
            post.getWriteAt(),
            post.getLikeCount()
        );
    }
}
