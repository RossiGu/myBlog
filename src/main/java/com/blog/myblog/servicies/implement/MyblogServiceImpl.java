package com.blog.myblog.servicies.implement;

import com.blog.myblog.models.Posts;
import com.blog.myblog.repositories.MyblogRepository;
import com.blog.myblog.servicies.MyblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyblogServiceImpl implements MyblogService {

    @Autowired
    MyblogRepository myblogRepository;

    @Override
    public List<Posts> findAll() {
        return myblogRepository.findAll();
    }

    @Override
    public Posts findById(Long id) {
        return myblogRepository.findById(id).get();
    }

    @Override
    public Posts save(Posts posts) {
        return myblogRepository.save(posts);
    }
}
