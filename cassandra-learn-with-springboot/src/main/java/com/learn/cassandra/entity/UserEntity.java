package com.learn.cassandra.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * @author Cool
 * @create 2020-10-15 10:07
 */
@Setter
@Getter
@Table(value = "user")
public class UserEntity {


    /**
     *数据库的结构 primary key(user_id);
     *
     **/

    //分区键
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED, ordinal = 0, name = "id")
    Integer id;

    @Column(value = "name")
    String name;

}

