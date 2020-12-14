package com.example.ddd.domain.entities;

import lombok.Data;

/**
 * 设备领域实体
 *
 * @author Cool
 * @create 2020-11-16
 */
@Data
public class Device {
    private String id;
    private String additionalInfo;
    private String customerId;
    private String type;
    private String name;
    private String searchText;
    private String tenantId;
    private Long operatorUserId;
    private Long deviceTypeId;
    private Integer deleteFlag = 0;
}
