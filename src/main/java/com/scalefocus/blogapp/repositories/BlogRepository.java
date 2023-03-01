package com.scalefocus.blogapp.repositories;

import com.scalefocus.blogapp.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findByTitleLikeIgnoreCase(String title);
    List<Blog> findByShortSummaryContainingIgnoreCase(String shortSummary);
}
