package com.blog.myblog.controllers;

import com.blog.myblog.models.Posts;
import com.blog.myblog.servicies.MyblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MyblogController {

    @Autowired
    MyblogService myblogService;

    @GetMapping("/posts")
    public ModelAndView getPosts() {
        ModelAndView mv = new ModelAndView("posts");
        List<Posts> posts = myblogService.findAll();
        mv.addObject("posts", posts);
        return mv;
    }
}
