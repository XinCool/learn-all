package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.BrokerEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("brokerDAO_HI")
public class BrokerDAO_HI extends BaseCommonDAO_HI<BrokerEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(BrokerDAO_HI.class);

	public BrokerDAO_HI() {
		super();
	}

}
