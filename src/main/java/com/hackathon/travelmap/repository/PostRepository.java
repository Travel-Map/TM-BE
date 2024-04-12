package com.hackathon.travelmap.repository;

import com.hackathon.travelmap.domain.Post;
import com.hackathon.travelmap.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long postId);

    List<Post> findAllByUser(User user);
}
