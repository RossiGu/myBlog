package com.blog.myblog.utils;

import com.blog.myblog.models.Posts;
import com.blog.myblog.repositories.MyblogRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TestConfig {

    @Autowired
    MyblogRepository myblogRepository;

    //@PostConstruct
    public void savePosts() {

        List<Posts> postList = new ArrayList<>();
        Posts post1 = new Posts();
        post1.setAuthor("Rossi Gustavo");
        post1.setDate(LocalDate.now());
        post1.setTitle("Docker");
        post1.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

        Posts post2 = new Posts();
        post2.setAuthor("Gustavo Rossi");
        post2.setDate(LocalDate.now());
        post2.setTitle("API REST");
        post2.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

        postList.add(post1);
        postList.add(post2);

        for(Posts post: postList){
            Posts postSaved = myblogRepository.save(post);
            System.out.println(postSaved.getId());
        }
    }
}