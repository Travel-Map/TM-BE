package com.hackathon.travelmap.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Getter
@Entity
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDate writeAt;

    @Column(nullable = false)
    private String travelStart;

    @Column(nullable = false)
    private String travelEnd;

    @Column(nullable = false)
    private String travelSpot;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Likes> likesList = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostPartnerTag> postPartnerTags = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<TravelImage> travelImages = new ArrayList<>();

    /* 빌더 */
    @Builder
    public Post(String title, String travelStart, String travelEnd, String travelSpot, String content, User user, Region region) {
        this.title = title;
        this.writeAt = LocalDate.now();
        this.travelStart = travelStart;
        this.travelEnd = travelEnd;
        this.travelSpot = travelSpot;
        this.content = content;
        this.user = user;
        this.region = region;
    }

    /* 연관 메서드 */
    public List<String> getTravelImages() {
        return travelImages.stream()
                .map(TravelImage::getImageUrl)
                .toList();
    }
}
