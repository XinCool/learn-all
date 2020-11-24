package com.example.hibernatetemplate.model.inter.server;

import com.example.hibernatetemplate.model.entity.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

/**
 * @author Cool
 * @create 2020-10-22 14:00
 */
@Service("userServer")
public class UserServer<IUser> extends HibernateDaoSupport implements com.example.hibernatetemplate.model.inter.IUser {


    @Override
    public User getById(String id) {
        return this.getHibernateTemplate().get(User.class,id);
    }

    @Override
    public void save(User user) {
        this.getHibernateTemplate().saveOrUpdate(user);

    }
}
