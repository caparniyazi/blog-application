package com.scalefocus.blogapp.services;

import com.scalefocus.blogapp.domain.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    Blog save(Blog blog);

    List<Blog> getAll();

    Optional<Blog> findById(Long id);
}
