package com.example.ddd.infrastructure.utils.id;

import cn.hutool.core.util.ReflectUtil;
import com.datastax.driver.core.utils.UUIDs;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

public class CustomUUIDGenerator implements Configurable,IdentifierGenerator {


    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {

    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

//        if(object instanceof RelationEntity_HI){
//            return (Serializable)ReflectUtil.getFieldValue(object, "fromId");
//        }
//
//        if(object instanceof AttributeKvEntity_HI){
//            return (Serializable)ReflectUtil.getFieldValue(object, "entityId");
//        }
        Object id =  ReflectUtil.getFieldValue(object, "id");
        if (id != null) {
            return (Serializable) id;
        }
        return   UUIDConverter.fromTimeUUID(UUIDs.timeBased());
    }
}
