package com.hackathon.travelmap.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String title;

    private LocalDate writeAt;

    private String travelStart;

    private String travelEnd;

    private String travelSpot;

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
}
