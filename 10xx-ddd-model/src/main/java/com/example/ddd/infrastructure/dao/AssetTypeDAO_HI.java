package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.AssetTypeEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("assetTypeDAO_HI")
public class AssetTypeDAO_HI extends BaseCommonDAO_HI<AssetTypeEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(AssetTypeDAO_HI.class);

	public AssetTypeDAO_HI() {
		super();
	}

}
