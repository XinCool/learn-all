package com.example.ddd.application.inter;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Cool
 * @create 2020-11-30 15:32
 */
public interface IAssetAppService {
    JSONObject findAssetById(String assetId);
}
