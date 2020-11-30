package com.example.ddd.domain.asset.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * AssetEntity_HI Entity Object
 * Fri Mar 27 15:41:06 CST 2020  Auto Generate
 */
@Data
public class AssetInfo implements Serializable {
    private String id;
    private String additionalInfo;
    private String customerId;
    private String name;
    private String searchText;
    private String tenantId;
    private String type;
    private Long operatorUserId;
    private String typeCode;
    private Integer deleteFlag = 0; //删除标识 0表示未删除 1表示删除了

    private Date creationDate; //创建日期
    private Long createdBy; //创建人
    private Date lastUpdateDate; //更新日期
    private Long lastUpdatedBy; //更新人
    private Long lastUpdateLogin; //最后登录ID
    private Integer versionNum; //版本号

}
