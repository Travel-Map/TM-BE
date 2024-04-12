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

    private String name;

    @OneToMany(mappedBy = "partner_tag", cascade = CascadeType.ALL)
    private List<PostPartnerTag> postPartnerTags = new ArrayList<>();
}
