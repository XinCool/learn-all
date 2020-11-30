package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.FocusDeviceEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("focusDeviceDAO_HI")
public class FocusDeviceDAO_HI extends BaseCommonDAO_HI<FocusDeviceEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(FocusDeviceDAO_HI.class);

	public FocusDeviceDAO_HI() {
		super();
	}

}
