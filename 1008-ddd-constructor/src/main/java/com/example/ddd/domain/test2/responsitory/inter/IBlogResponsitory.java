package com.example.ddd.domain.test2.responsitory.inter;

import com.example.ddd.domain.test2.entities.BlogEntities;

/**
 * @author Cool
 * @create 2020-11-13 13:54
 */
public interface IBlogResponsitory extends IResponsitory<BlogEntities> {
   Object save(BlogEntities blog);
}
