package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.AttrMonitorLayoutEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("attrMonitorLayoutDAO_HI")
public class AttrMonitorLayoutDAO_HI extends BaseCommonDAO_HI<AttrMonitorLayoutEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(AttrMonitorLayoutDAO_HI.class);

	public AttrMonitorLayoutDAO_HI() {
		super();
	}

}
