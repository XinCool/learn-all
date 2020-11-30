package com.example.ddd.application.service;

import com.alibaba.fastjson.JSONObject;
import com.example.ddd.application.inter.IAssetAppService;
import com.example.ddd.domain.asset.entities.AssetInfo;
import com.example.ddd.domain.asset.repository.IAssetRepository;
import com.example.ddd.domain.device.repository.IDeviceRepository;
import com.example.ddd.domain.relation.repository.IRelationRepository;
import com.example.ddd.infrastructure.utils.enums.EntityType;
import com.example.ddd.infrastructure.utils.enums.RelationType;
import com.example.ddd.infrastructure.utils.enums.RelationTypeGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Cool
 * @create 2020-11-30 15:32
 */
@Component("assetAppService")
public class AssetAppService implements IAssetAppService {

    @Autowired
    private IAssetRepository assetRepository;
    @Autowired
    private IDeviceRepository deviceRepository;
    @Autowired
    private IRelationRepository relationRepository;

    @Override
    public JSONObject findAssetById(String assetId) {
        AssetInfo assetInfo = assetRepository.getById(assetId);
        JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(assetInfo));
        result.put("parent",relationRepository.findByToId(assetId, EntityType.DEVICE.name(),EntityType.ASSET.name(), RelationType.Contains.name(), RelationTypeGroup.COMMON.name()));
        return result;
    }
}
