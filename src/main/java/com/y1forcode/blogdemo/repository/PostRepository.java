package com.y1forcode.blogdemo.repository;


import com.y1forcode.blogdemo.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}