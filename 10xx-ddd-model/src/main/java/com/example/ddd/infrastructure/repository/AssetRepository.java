package com.example.ddd.infrastructure.repository;

import cn.hutool.core.bean.BeanUtil;
import com.example.ddd.domain.asset.entities.AssetInfo;
import com.example.ddd.domain.asset.repository.IAssetRepository;
import com.example.ddd.infrastructure.entities.AssetEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Cool
 * @create 2020-11-30 15:25
 */
@Component("assetRepository")
public class AssetRepository implements IAssetRepository {
    @Autowired
    BaseCommonDAO_HI<AssetEntity_HI> assetDAO_HI;

    @Override
    public AssetInfo getById(String AssetId) {
        AssetEntity_HI assetEntityHi = assetDAO_HI.getById(AssetId);
        AssetInfo assetInfo = new AssetInfo();
        BeanUtil.copyProperties(assetEntityHi,assetInfo);
        return assetInfo;
    }
}
