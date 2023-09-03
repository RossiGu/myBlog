package com.blog.myblog.servicies;

import com.blog.myblog.models.Posts;

import java.util.List;

public interface MyblogService {

    List<Posts> findAll();
    Posts findById(Long id);
    Posts save(Posts posts);
}
