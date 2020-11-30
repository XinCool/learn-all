package com.example.ddd.domain.device.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * kv
 *
 * @author Cool
 * @create 2020-11-16
 */
@Data
public class AttributeKvInfo implements Serializable {
    private String entityType;
    private String entityId;
    private String attributeType;
    private String attributeKey;
    private String attributeName;
    private Boolean boolV;
    private String strV;
    private Long longV;
    private Double dblV;
    private Long lastUpdateTs;
    private Long operatorUserId;
    private String id;
    /*private String description;
    private Integer deleteFlag = 0; //删除标识 0表示未删除 1表示删除了
    private Date creationDate; //创建日期
    private Long createdBy; //创建人
    private Date lastUpdateDate; //更新日期
    private Long lastUpdatedBy; //更新人
    private Long lastUpdateLogin; //最后登录ID
    private Integer versionNum; //版本号*/
}
