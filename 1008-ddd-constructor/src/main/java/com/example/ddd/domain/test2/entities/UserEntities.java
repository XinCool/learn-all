package com.example.ddd.domain.test2.entities;

/**
 * @author Cool
 * @create 2020-11-13 13:39
 */
public class UserEntities {
    private String userId;

    public BlogEntities createBlog(String blogName){
        return new BlogEntities(blogName);
    }
}
