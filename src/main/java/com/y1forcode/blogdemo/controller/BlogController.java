package com.y1forcode.blogdemo.controller;



import com.y1forcode.blogdemo.entity.Post;
import com.y1forcode.blogdemo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "index";
    }

    @GetMapping("/post/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        Optional<Post> post = postService.getPostById(id);
        if (post.isPresent()) {
            model.addAttribute("post", post.get());
            return "view";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/post/new")
    public String newPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "create";
    }

    @PostMapping("/post")
    public String savePost(@ModelAttribute Post post) {
        postService.savePost(post);
        return "redirect:/";
    }

    @GetMapping("/post/edit/{id}")
    public String editPostForm(@PathVariable Long id, Model model) {
        Optional<Post> post = postService.getPostById(id);
        if (post.isPresent()) {
            model.addAttribute("post", post.get());
            return "edit";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/post/update/{id}")
    public String updatePost(@PathVariable Long id, @ModelAttribute Post post) {
        post.setId(id);
        postService.savePost(post);
        return "redirect:/post/" + id;
    }

    @GetMapping("/post/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/";
    }
}