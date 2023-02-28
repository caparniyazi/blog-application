package com.scalefocus.blogapp.bootstrap;

import com.scalefocus.blogapp.domain.Blog;
import com.scalefocus.blogapp.domain.BlogUser;
import com.scalefocus.blogapp.services.BlogService;
import com.scalefocus.blogapp.services.BlogUserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BlogLoader implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(BlogLoader.class);
    private final BlogService blogService;
    private final BlogUserService blogUserService;

    @Override
    public void run(String... args) {
        log.info("Loading data..");
        List<Blog> blogPosts = blogService.getAll();

        if (blogPosts.size() == 0) {    // No data yet..
            BlogUser user1 = BlogUser.builder().firstName("Niyazi").lastName("Çapar").username("niyazi.capar").password("xxx").build();
            BlogUser user2 = BlogUser.builder().firstName("Neslihan").lastName("Çapar").username("neslihan.capar").password("yyy").build();
            blogUserService.save(user1);
            blogUserService.save(user2);

            blogService.save(Blog.builder().title("JPA").body("text1").shortSummary("summary1").blogUser(user1).build());
            blogService.save(Blog.builder().title("JSF").body("text2").shortSummary("summary2").blogUser(user1).build());
            blogService.save(Blog.builder().title("Microservices").body("text3").shortSummary("summary3").blogUser(user2).build());
            blogService.save(Blog.builder().title("Spring Boot & Cloud").body("text4").shortSummary("summary4").blogUser(user2).build());
        }
    }
}
