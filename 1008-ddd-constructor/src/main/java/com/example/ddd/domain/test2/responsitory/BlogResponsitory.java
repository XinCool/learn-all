package com.example.ddd.domain.test2.responsitory;

import com.example.ddd.domain.test2.entities.BlogEntities;
import com.example.ddd.domain.test2.responsitory.inter.IBlogResponsitory;
import org.springframework.stereotype.Component;

/**
 * @author Cool
 * @create 2020-11-13 13:40
 */
@Component
public class BlogResponsitory implements IBlogResponsitory {

    @Override
    public Object save(BlogEntities blog) {
        return this.save(blog);
    }
}
