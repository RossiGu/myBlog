package com.blog.myblog.repositories;

import com.blog.myblog.models.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyblogRepository extends JpaRepository<Posts, Long> {
}
