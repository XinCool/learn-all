package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.RuleChainEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("ruleChainDAO_HI")
public class RuleChainDAO_HI extends BaseCommonDAO_HI<RuleChainEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(RuleChainDAO_HI.class);

	public RuleChainDAO_HI() {
		super();
	}

}
