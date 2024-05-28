package com.y1forcode.blogdemo.service;


import com.y1forcode.blogdemo.entity.Post;
import com.y1forcode.blogdemo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return (List<Post>) postRepository.findAll();
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}