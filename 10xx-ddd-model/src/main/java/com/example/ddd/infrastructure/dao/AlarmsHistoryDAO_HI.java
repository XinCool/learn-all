package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.AlarmsHistoryEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("alarmsHistoryDAO_HI")
public class AlarmsHistoryDAO_HI extends BaseCommonDAO_HI<AlarmsHistoryEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(AlarmsHistoryDAO_HI.class);

	public AlarmsHistoryDAO_HI() {
		super();
	}

}
