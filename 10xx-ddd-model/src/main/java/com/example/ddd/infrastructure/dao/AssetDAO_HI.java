package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.AssetEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("assetDAO_HI")
public class AssetDAO_HI extends BaseCommonDAO_HI<AssetEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(AssetDAO_HI.class);

	public AssetDAO_HI() {
		super();
	}

}
