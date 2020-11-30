package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.WidgetsBundleEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("widgetsBundleDAO_HI")
public class WidgetsBundleDAO_HI extends BaseCommonDAO_HI<WidgetsBundleEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(WidgetsBundleDAO_HI.class);

	public WidgetsBundleDAO_HI() {
		super();
	}

}
