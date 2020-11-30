package com.example.ddd.infrastructure.entities.readonly;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * RelationEntity_HI Entity Object
 * Fri Mar 27 15:41:26 CST 2020  Auto Generate
 */
public class RelationEntity_HI_RO implements Serializable{


	public final  static  String QUER_SQL="SELECT\n" +
			"\tr.from_id as fromId ,\n" +
			"\tr.from_type as fromType ,\n" +
			"\tr.to_id as toId ,\n" +
			" d.name as deviceName \n" +
			"FROM\n" +
			"\trelation r\n" +
			"left join   device  d  on  d.id=r.from_id and d.delete_flag=0 \t\n" +
			"WHERE  \n" ;


    private String fromId;
    private String fromType;
    private String toId;
    private String toType;
    private String relationTypeGroup;
    private String relationType;
    private String additionalInfo;
    private Long operatorUserId;
    private String deviceName;

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public void setFromId(String fromId) {
		this.fromId = fromId;
	}

	public String getFromId() {
		return fromId;
	}

	public void setFromType(String fromType) {
		this.fromType = fromType;
	}

	public String getFromType() {
		return fromType;
	}

	public void setToId(String toId) {
		this.toId = toId;
	}

	public String getToId() {
		return toId;
	}

	public void setToType(String toType) {
		this.toType = toType;
	}

	public String getToType() {
		return toType;
	}

	public void setRelationTypeGroup(String relationTypeGroup) {
		this.relationTypeGroup = relationTypeGroup;
	}
	public String getRelationTypeGroup() {
		return relationTypeGroup;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	public String getRelationType() {
		return relationType;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setOperatorUserId(Long operatorUserId) {
		this.operatorUserId = operatorUserId;
	}

	@Transient	
	public Long getOperatorUserId() {
		return operatorUserId;
	}

	private Date creationDate; //创建日期
	private Long createdBy; //创建人
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateDate; //更新日期
	private Long lastUpdatedBy; //更新人
	private Long lastUpdateLogin; //最后登录ID
	private Integer versionNum; //版本号

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdateLogin(Long lastUpdateLogin) {
		this.lastUpdateLogin = lastUpdateLogin;
	}

	public Long getLastUpdateLogin() {
		return lastUpdateLogin;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}

	@Version
	public Integer getVersionNum() {
		return versionNum;
	}
}
