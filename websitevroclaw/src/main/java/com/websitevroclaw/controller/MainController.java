package com.websitevroclaw.controller;

import com.websitevroclaw.entity.Blog;
import com.websitevroclaw.repos.BlogsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class MainController {
    private final BlogsRepo blogRepo;

    @Autowired
    public MainController(BlogsRepo blogRepo) {
        this.blogRepo = blogRepo;
    }

    @GetMapping
    public String getter() {
        return "index";
    }

    @GetMapping("useful")
    public String getUseful() {
        return "useful";
    }

    @GetMapping("places")
    public String getPlaces() {
        return "places";
    }

    @GetMapping("blog")
    public ModelAndView getBlogs() {
        ArrayList<Blog> blogs = (ArrayList<Blog>) blogRepo.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("blogs", blogs);
        mav.setViewName("blogs");
        return mav;
    }

    @GetMapping("oneBlog")
    public ModelAndView getBlog(@RequestParam("id") Long id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("blog", blogRepo.findById(id));
        mav.setViewName("blog");
        return mav;
    }

    @PostMapping
    public String postBlog(@RequestParam("name") String username, @RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("image-url") String url) {
        blogRepo.save(new Blog(username, content, url, title));
        return "redirect:blog";
    }
}
