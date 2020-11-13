package com.example.ddd.domain.test2.responsitory;

import com.example.ddd.domain.test2.entities.UserEntities;
import com.example.ddd.domain.test2.responsitory.inter.IUserRepository;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Cool
 * @create 2020-11-13 13:40
 */
@ComponentScan
public class UserRepository implements IUserRepository {
    @Override
    public Object save(UserEntities user) {
        return this.save(user);
    }

    @Override
    public UserEntities getUserById(String userId) {
        return this.getUserById(userId);
    }
}
