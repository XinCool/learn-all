package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.ComponentDescriptorEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("componentDescriptorDAO_HI")
public class ComponentDescriptorDAO_HI extends BaseCommonDAO_HI<ComponentDescriptorEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(ComponentDescriptorDAO_HI.class);

	public ComponentDescriptorDAO_HI() {
		super();
	}

}
