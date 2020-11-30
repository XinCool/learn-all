package com.example.ddd.interfaces.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.ddd.application.inter.IAssetAppService;
import com.sie.iot.common.bean.ResponseData;
import com.sie.iot.common.iotenum.ResponseMsgCode;
import com.sie.iot.component.exception.ApplicationRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cool
 * @create 2020-11-30 15:31
 */
@RestController
@RequestMapping("/asset")
public class AssetController {
    @Autowired
    private IAssetAppService assetAppService;
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/get-id/{assetId}")
    public ResponseData findAssetById(@PathVariable("assetId") String assetId){
        try {
            JSONObject assetWithParentDevice = assetAppService.findAssetById(assetId);
            return new ResponseData(ResponseMsgCode.SUCCESS.msgCode,assetWithParentDevice, redisTemplate);
        } catch (Exception e) {
            throw new ApplicationRuntimeException(ResponseMsgCode.ERROR.msgCode, e);
        }
    }

}
