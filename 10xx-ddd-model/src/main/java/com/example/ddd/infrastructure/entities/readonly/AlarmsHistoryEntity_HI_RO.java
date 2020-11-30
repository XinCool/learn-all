package com.example.ddd.infrastructure.entities.readonly;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * AlarmsHistoryEntity_HI_RO Entity Object
 * Tue May 26 10:30:40 CST 2020  Auto Generate
 */

public class AlarmsHistoryEntity_HI_RO implements Serializable {


    public final static String QUERY_SQL =    "   SELECT\n" +
            "h.id as id , "+
            "\th.state as state ,\n" +
            "\th.description as description ,\n" +
            "\th.data_time  as dataTime,\n" +
            "\tr.rule_name as ruleName ,\n" +
            " a.`name`  as assetName, \n" +
            " h.asset_id   as assetId, \n" +
            "h.creation_date  as creationDate, "+
            "d.name  as deviceName, "+
            "d.id  as deviceId "+
            "FROM\n" +
            "\talarms_history h\n" +
            "LEFT JOIN alarms_rule r ON r.id = h.alarms_id\n" +
            "left join device d on h.device_id=d.id " +
            "left join asset a on h.asset_id=a.id " +
            "where  1=1";
    public final static String COUNT_SQL = "SELECT\n" +
            "count(h.id)"+

            "FROM\n" +
            "\talarms_history h\n" +
            "LEFT JOIN alarms_rule r ON r.id = h.alarms_id\n" +
            "left join device d on h.device_id=d.id " +
            "left join asset a on h.asset_id=a.id " +
            "where  1=1";

    public final static String QUERY_DISTINCT_SQL = "SELECT\n" +
            "h.id as id , "+
            "\th.state as state ,\n" +
            "\th.asset_id  as assetId\n" +
            "FROM\n" +
            "\talarms_history h\n" +
            "where  1=1   and  not  EXISTS(\n" +
            "\t\tSELECT\n" +
            "\t\t\t1\n" +
            "\t\tFROM\n" +
            "\t\t\talarms_history \n" +
            "\t\tWHERE \n" +
            "                     asset_id=h.asset_id\n" +
            "                     and id>h.id  \n" +
            "\t)";

    private Long id; //主键
    private Long alarmsId; //规则id
    private Integer state; //状态
    private String description; //描述
    private String assetId;
    /**
     * 设备id
     */
    private String deviceId;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    private Date creationDate; //创建时间

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
        private Date dataTime; //数据时间
    /**
     * 设备id
     */
    private String deviceName;
    private String assetName;

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    private String ruleName;

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceId) {
        this.deviceName = deviceId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setAlarmsId(Long alarmsId) {
        this.alarmsId = alarmsId;
    }


    public Long getAlarmsId() {
        return alarmsId;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }
}
