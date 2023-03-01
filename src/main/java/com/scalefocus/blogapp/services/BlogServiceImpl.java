package com.scalefocus.blogapp.services;

import com.scalefocus.blogapp.domain.Blog;
import com.scalefocus.blogapp.repositories.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BlogServiceImpl implements BlogService {
	private final BlogRepository blogRepository;
	@Override
	public Blog save(Blog blog) {
		return blogRepository.save(blog);
	}

	@Override
	public Optional<Blog> findById(Long id) {
		return blogRepository.findById(id);
	}

	@Override
	public List<Blog> findByTitle(String title) {
		return blogRepository.findByTitleLikeIgnoreCase(title);
	}

	@Override
	public List<Blog> findByShortSummary(String shortSummary) {
		return blogRepository.findByShortSummaryContainingIgnoreCase(shortSummary);
	}

	@Override
	public List<Blog> getAll() {
		return blogRepository.findAll();
	}
}
