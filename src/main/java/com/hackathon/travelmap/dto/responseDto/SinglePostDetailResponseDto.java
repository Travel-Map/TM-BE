package com.hackathon.travelmap.dto.responseDto;

import com.hackathon.travelmap.domain.Post;
import com.hackathon.travelmap.domain.Region;
import com.hackathon.travelmap.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SinglePostDetailResponseDto {

    private Long postId;

    private String title;

    private String writerName;

    private String regionName;

    private LocalDate writeAt;

    private String travelStart;

    private String travelEnd;

    private List<String> travelImageUrl;

    private String travelSpot;

    private String content;

    public static SinglePostDetailResponseDto of(Post post) {

        // 사실 User와 Region이 null이 될 수 없기 때문에 예외를 던질 필요는 없다.
        // 만약 예외를 던지더라도 메시지는 보내지 않아 안티패턴이 될 수 있다.
        User user = Optional.ofNullable(post.getUser()).orElseThrow(RuntimeException::new);
        Region region = Optional.ofNullable(post.getRegion()).orElseThrow(RuntimeException::new);

        return new SinglePostDetailResponseDto(
                post.getId(),
                post.getTitle(),
                user.getNickname(),
                region.getName(),
                post.getWriteAt(),
                post.getTravelStart(),
                post.getTravelEnd(),
                post.getTravelImages(),
                post.getTravelSpot(),
                post.getContent()
        );
    }

}
