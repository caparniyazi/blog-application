package com.scalefocus.blogapp.services;

import com.scalefocus.blogapp.domain.BlogUser;
import com.scalefocus.blogapp.repositories.BlogUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogUserServiceImpl implements BlogUserService {
    private final BlogUserRepository blogUserRepository;

    @Override
    public BlogUser save(BlogUser blogUser) {
        return blogUserRepository.save(blogUser);
    }
}
