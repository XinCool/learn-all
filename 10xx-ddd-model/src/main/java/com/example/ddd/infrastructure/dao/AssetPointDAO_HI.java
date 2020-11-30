package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.AssetPointEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("assetPointDAO_HI")
public class AssetPointDAO_HI extends BaseCommonDAO_HI<AssetPointEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(AssetPointDAO_HI.class);

	public AssetPointDAO_HI() {
		super();
	}

}
