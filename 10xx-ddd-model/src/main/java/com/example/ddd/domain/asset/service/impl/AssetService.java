package com.example.ddd.domain.asset.service.impl;

import com.example.ddd.domain.asset.entities.AssetInfo;
import com.example.ddd.domain.asset.service.IAssetService;
import com.example.ddd.infrastructure.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Cool
 * @create 2020-11-30 15:28
 */
@Component("assetService")
public class AssetService implements IAssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public AssetInfo findById(String AssetId) {
        return assetRepository.getById(AssetId);
    }
}
