package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.EventEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("eventDAO_HI")
public class EventDAO_HI extends BaseCommonDAO_HI<EventEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(EventDAO_HI.class);

	public EventDAO_HI() {
		super();
	}

}
