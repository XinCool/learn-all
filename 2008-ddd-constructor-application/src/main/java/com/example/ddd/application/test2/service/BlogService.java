package com.example.ddd.application.test2.service;

import com.example.ddd.domain.test2.entities.BlogEntities;
import com.example.ddd.domain.test2.entities.UserEntities;
import com.example.ddd.domain.test2.responsitory.BlogResponsitory;
import com.example.ddd.domain.test2.responsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Cool
 * @create 2020-11-13 13:38
 */
public class BlogService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogResponsitory blogRepository;

    @Transactional
    public void createBlog(String blogName, String userId) {
        UserEntities user = userRepository.getUserById(userId);
        BlogEntities blog = user.createBlog(blogName);
        blogRepository.save(blog);
    }
}
