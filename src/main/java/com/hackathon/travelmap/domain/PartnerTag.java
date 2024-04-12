package com.hackathon.travelmap.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PartnerTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partner_tag_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "partnerTag", cascade = CascadeType.ALL)
    private List<PostPartnerTag> postPartnerTags = new ArrayList<>();
}
