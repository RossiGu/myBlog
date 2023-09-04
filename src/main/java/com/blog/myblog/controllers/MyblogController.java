package com.blog.myblog.controllers;

import com.blog.myblog.models.Posts;
import com.blog.myblog.servicies.MyblogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
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

    @GetMapping("/posts/{id}")
    public ModelAndView getPostDetails(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("postDetails");
        Posts posts = myblogService.findById(id);
        mv.addObject("posts", posts);
        return mv;
    }

    @GetMapping("/newpost")
    public String getPostForm() {
        return "postForm";
    }

    @PostMapping("/newpost")
    public String savePost(@Valid Posts posts, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos obrigatórios!");
            return "redirect:/newpost";
        }
        posts.setDate(LocalDate.now());
        myblogService.save(posts);
        return "redirect:/posts";
    }
}
