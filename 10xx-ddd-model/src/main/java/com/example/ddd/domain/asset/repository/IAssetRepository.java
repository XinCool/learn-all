package com.example.ddd.domain.asset.repository;

import com.example.ddd.domain.asset.entities.AssetInfo;

/**
 * @author Cool
 * @create 2020-11-30 15:23
 */
public interface IAssetRepository {
    /**
     * 根据资产Id查询资产信息
     * @param AssetId
     * @return
     */
    AssetInfo getById(String AssetId);
}
