package com.hackathon.travelmap.dto.requestDto;

import com.hackathon.travelmap.domain.Post;
import com.hackathon.travelmap.domain.Region;
import com.hackathon.travelmap.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class CreatePostRequestDto {

    private String title;

    private String travelStart;

    private String travelEnd;

    private String travelSpot;

    private String content;

    private Long regionId;

    public Post toPost(User user, Region region) {
        return Post.builder()
                .title(title)
                .travelStart(travelStart)
                .travelEnd(travelEnd)
                .travelSpot(travelSpot)
                .content(content)
                .user(user)
                .region(region)
                .build();
    }
}
