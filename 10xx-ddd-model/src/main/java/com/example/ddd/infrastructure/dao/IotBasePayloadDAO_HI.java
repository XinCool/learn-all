package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.IotBasePayloadEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("iotBasePayloadDAO_HI")
public class IotBasePayloadDAO_HI extends BaseCommonDAO_HI<IotBasePayloadEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(IotBasePayloadDAO_HI.class);

	public IotBasePayloadDAO_HI() {
		super();
	}

}
