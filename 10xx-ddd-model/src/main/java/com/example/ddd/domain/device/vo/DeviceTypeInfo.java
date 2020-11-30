package com.example.ddd.domain.device.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * DeviceTypeEntity_HI Entity Object
 * Tue Jul 14 17:38:35 CST 2020  Auto Generate
 */
@Data
public class DeviceTypeInfo implements Serializable{
    private Long dtid;
    private String typeName; //类型名称
    private String typeCode; //类型编码 (名称全拼+租户id)
    private String tenantId; //租户ID
    private String description; //描述
    private Boolean useStatus; //是否启用
    /*private Date creationDate; //创建日期
    private Long createdBy; //创建人
    private Date lastUpdateDate; //更新日期
    private Long lastUpdatedBy; //更新人
    private Long lastUpdateLogin; //最后登录ID
    private Integer deleteFlag=0; //删除标识 0表示未删除 1表示删除了
    private Integer versionNum; //版本号
    private Long operatorUserId;*/
    public DeviceTypeInfo(Long dtid){
        this.dtid = dtid;
    }
}
