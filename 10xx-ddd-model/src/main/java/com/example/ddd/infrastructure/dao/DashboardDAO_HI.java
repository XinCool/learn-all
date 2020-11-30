package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.DashboardEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("dashboardDAO_HI")
public class DashboardDAO_HI extends BaseCommonDAO_HI<DashboardEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(DashboardDAO_HI.class);

	public DashboardDAO_HI() {
		super();
	}

}
