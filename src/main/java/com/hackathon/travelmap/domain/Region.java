package com.hackathon.travelmap.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Long id;

    @Getter
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean isVisited;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

}
