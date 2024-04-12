package com.hackathon.travelmap.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Long id;

    private String name;

    private Boolean isVisited;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();
}
