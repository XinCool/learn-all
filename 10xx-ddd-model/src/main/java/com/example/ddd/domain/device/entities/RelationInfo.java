package com.example.ddd.domain.device.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * RelationEntity_HI Entity Object
 * Fri Mar 27 15:41:26 CST 2020  Auto Generate
 */
@Data
public class RelationInfo implements Serializable {

	private String fromId;
    private String fromType;
    private String toId;
    private String toType;
    private String relationTypeGroup;
    private String relationType;
    private String additionalInfo;
    private Long operatorUserId;
    private Long id;
    private Integer deleteFlag = 0; //删除标识 0表示未删除 1表示删除了
    private Date creationDate; //创建日期
    private Long createdBy; //创建人
    private Date lastUpdateDate; //更新日期
    private Long lastUpdatedBy; //更新人
    private Long lastUpdateLogin; //最后登录ID
    private Integer versionNum; //版本号

}
