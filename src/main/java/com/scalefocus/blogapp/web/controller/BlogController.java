package com.scalefocus.blogapp.web.controller;

import com.scalefocus.blogapp.domain.Blog;
import com.scalefocus.blogapp.services.BlogService;
import com.scalefocus.blogapp.services.BlogUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class BlogController {
	private final BlogService blogService;
	private final BlogUserService blogUserService;

	@GetMapping("/listBlogPosts")
	public ResponseEntity<List<Blog>> getBlogPosts() {
		return new ResponseEntity<>(blogService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/blogPost/{id}")
	public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
		Optional<Blog> blog = blogService.findById(id);
		return blog.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping("/blogPost/title/{title}")
	public ResponseEntity<List<Blog>> getBlogByTitle(@PathVariable String title) {
		return new ResponseEntity<>(blogService.findByTitle(title), HttpStatus.OK);
	}

	@GetMapping("/blogPost/summary/{shortSummary}")
	public ResponseEntity<List<Blog>> getBlogByShortSummary(@PathVariable String shortSummary) {
		return new ResponseEntity<>(blogService.findByShortSummary(shortSummary), HttpStatus.OK);
	}

	@PostMapping(path = "/saveBlogPost")
	@Transactional
	public ResponseEntity<?> save(@RequestBody @Valid Blog blog) {
		return new ResponseEntity<>(blogService.save(blog), HttpStatus.CREATED);
	}
}
