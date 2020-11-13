package com.example.ddd.domain.test2.responsitory.inter;

import com.example.ddd.domain.test2.entities.UserEntities;

/**
 * @author Cool
 * @create 2020-11-13 13:56
 */
public interface IUserRepository extends IResponsitory<UserEntities>{
    UserEntities getUserById(String userId);
}
