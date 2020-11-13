package com.example.ddd.domain.test2.responsitory.inter;

/**
 * @author Cool
 * @create 2020-11-13 13:51
 */
public interface IResponsitory<T extends Object> {
   Object save(T object);
}
