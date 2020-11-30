package com.example.ddd.domain.asset.service;

import com.example.ddd.domain.asset.entities.AssetInfo;

/**
 * @author Cool
 * @create 2020-11-30 15:28
 */
public interface IAssetService {
    AssetInfo findById(String AssetId);
}
