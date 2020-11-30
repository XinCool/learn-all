package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.RuleNodeEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("ruleNodeDAO_HI")
public class RuleNodeDAO_HI extends BaseCommonDAO_HI<RuleNodeEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(RuleNodeDAO_HI.class);

	public RuleNodeDAO_HI() {
		super();
	}

}
