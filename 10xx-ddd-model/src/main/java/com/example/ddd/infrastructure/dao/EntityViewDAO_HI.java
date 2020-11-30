package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.EntityViewEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("entityViewDAO_HI")
public class EntityViewDAO_HI extends BaseCommonDAO_HI<EntityViewEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(EntityViewDAO_HI.class);

	public EntityViewDAO_HI() {
		super();
	}

}
