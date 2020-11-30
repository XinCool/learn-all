package com.example.ddd.domain.device.entities;

import lombok.Data;

import java.util.Date;

/**
 * 设备领域实体
 *
 * @author Cool
 * @create 2020-11-16
 */
@Data
public class DeviceInfo {
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
    private Date creationDate; //创建日期
    private Long createdBy; //创建人
    private Date lastUpdateDate; //更新日期
    private Long lastUpdatedBy; //更新人
    private Long lastUpdateLogin; //最后登录ID
    private Integer versionNum; //版本号

    /**
     * 删除设备
     */
    private void delete(){
        this.setDeleteFlag(1);
    }
}
