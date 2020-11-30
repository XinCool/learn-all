package com.example.ddd.domain.device.vo;

import lombok.Data;

/**
 * @author Cool
 * @create 2020-11-30 10:16
 */
@Data
public class TenantInfo {
    private String tenantId;
    public TenantInfo(String tenantId){
        this.tenantId = tenantId;
    }
}
