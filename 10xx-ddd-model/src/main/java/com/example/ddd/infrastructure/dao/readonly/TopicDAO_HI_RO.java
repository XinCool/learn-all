package com.example.ddd.infrastructure.dao.readonly;

import com.example.ddd.infrastructure.entities.readonly.TopicEntity_HI_RO;
import com.siefw.hibernate.core.dao.DynamicViewObjectImpl;
import org.springframework.stereotype.Component;

@Component("topicDAO_HI_RO")
public class TopicDAO_HI_RO extends DynamicViewObjectImpl<TopicEntity_HI_RO>  {

}
