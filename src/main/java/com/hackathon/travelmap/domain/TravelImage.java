package com.hackathon.travelmap.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class TravelImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "travel_image_id")
    private Long id;

    @Getter
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
}
