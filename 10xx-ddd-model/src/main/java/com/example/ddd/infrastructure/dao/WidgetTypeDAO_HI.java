package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.WidgetTypeEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("widgetTypeDAO_HI")
public class WidgetTypeDAO_HI extends BaseCommonDAO_HI<WidgetTypeEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(WidgetTypeDAO_HI.class);

	public WidgetTypeDAO_HI() {
		super();
	}

}
