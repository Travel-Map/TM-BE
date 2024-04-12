package com.hackathon.travelmap.domain;

import jakarta.persistence.*;

@Entity
public class PostPartnerTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_partner_tag_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_tag_id")
    private PartnerTag partnerTag;
}
