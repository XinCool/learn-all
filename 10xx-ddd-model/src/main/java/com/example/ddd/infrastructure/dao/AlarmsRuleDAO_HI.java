package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.AlarmsRuleEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("alarmsRuleDAO_HI")
public class AlarmsRuleDAO_HI extends BaseCommonDAO_HI<AlarmsRuleEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(AlarmsRuleDAO_HI.class);

	public AlarmsRuleDAO_HI() {
		super();
	}

}
