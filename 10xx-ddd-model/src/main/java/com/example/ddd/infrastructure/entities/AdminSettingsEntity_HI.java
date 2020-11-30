package com.example.ddd.infrastructure.entities;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.ddd.infrastructure.utils.mapping.JsonStringType;
import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * AdminSettingsEntity_HI Entity Object
 * Fri Mar 27 15:41:05 CST 2020  Auto Generate
 */
@Entity
@TypeDef(name = "json", typeClass = JsonStringType.class)
@Table(name="admin_settings")
public class AdminSettingsEntity_HI implements Serializable{
    private String id;
    private JsonNode jsonValue;
    private String key;
    private Long operatorUserId;


	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name="id", nullable=false, length=31)
	@GenericGenerator(name = "idGenerator", strategy = "com.example.ddd.infrastructure.utils.id.CustomUUIDGenerator")
	@GeneratedValue(generator = "idGenerator")
	public String getId() {
		return id;
	}

	public void setJsonValue(JsonNode jsonValue) {
		this.jsonValue = jsonValue;
	}

	@Type(type = "json")
	@Column(name="json_value", nullable=true, length=0)	
	public JsonNode getJsonValue() {
		return jsonValue;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Column(name="`key`", nullable=true, length=255)
	public String getKey() {
		return key;
	}

	public void setOperatorUserId(Long operatorUserId) {
		this.operatorUserId = operatorUserId;
	}

	@Transient	
	public Long getOperatorUserId() {
		return operatorUserId;
	}


	@JSONField(format="yyyy-MM-dd HH:mm:ss")
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

	@Column(name="creation_date", nullable=true, length=0)
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name="created_by", nullable=true, length=20)
	public Long getCreatedBy() {
		return createdBy;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@Column(name="last_update_date", nullable=true, length=0)
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	@Column(name="last_updated_by", nullable=true, length=20)
	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdateLogin(Long lastUpdateLogin) {
		this.lastUpdateLogin = lastUpdateLogin;
	}

	@Column(name="last_update_login", nullable=true, length=20)
	public Long getLastUpdateLogin() {
		return lastUpdateLogin;
	}


	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}

	@Version
	@Column(name="version_num", nullable=false, length=11)
	public Integer getVersionNum() {
		return versionNum;
	}
}
