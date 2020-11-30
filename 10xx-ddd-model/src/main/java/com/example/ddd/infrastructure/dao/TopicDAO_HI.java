package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.TopicEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("topicDAO_HI")
public class TopicDAO_HI extends BaseCommonDAO_HI<TopicEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(TopicDAO_HI.class);

	public TopicDAO_HI() {
		super();
	}

}
