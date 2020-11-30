package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.AlarmEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("alarmDAO_HI")
public class AlarmDAO_HI extends BaseCommonDAO_HI<AlarmEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(AlarmDAO_HI.class);

	public AlarmDAO_HI() {
		super();
	}

}
