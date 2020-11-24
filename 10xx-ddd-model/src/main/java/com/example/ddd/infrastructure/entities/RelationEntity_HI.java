package com.example.ddd.infrastructure.entities;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * RelationEntity_HI Entity Object
 * Fri Mar 27 15:41:26 CST 2020  Auto Generate
 */
@Entity
@Table(name="relation")
public class RelationEntity_HI implements Serializable{

    private String fromId;
    private String fromType;
    private String toId;
    private String toType;
    private String relationTypeGroup;
    private String relationType;
    private String additionalInfo;
    private Long operatorUserId;



	private Integer deleteFlag = 0; //删除标识 0表示未删除 1表示删除了

	private Long id;

//	@Id
//	@Column(name="id", nullable=false, length=31)
//	@GenericGenerator(name = "idGenerator", strategy = "com.sie.iot.platform.asset.model.utils.id.CustomUUIDGenerator")
//	@GeneratedValue(generator = "idGenerator")
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "com.example.ddd.infrastructure.utils.id.CustomUUIDGenerator")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="id", nullable=false, length=20)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public void setFromId(String fromId) {
		this.fromId = fromId;
	}

//	@Id
//	@GenericGenerator(name = "idGenerator", strategy = "com.sie.iot.platform.asset.model.utils.id.CustomUUIDGenerator")
//	@GeneratedValue(generator = "idGenerator")
	@Column(name="from_id", nullable=true, length=31)	
	public String getFromId() {
		return fromId;
	}

	public void setFromType(String fromType) {
		this.fromType = fromType;
	}

	@Column(name="from_type", nullable=true, length=255)	
	public String getFromType() {
		return fromType;
	}

	public void setToId(String toId) {
		this.toId = toId;
	}

	@Column(name="to_id", nullable=true, length=31)	
	public String getToId() {
		return toId;
	}

	public void setToType(String toType) {
		this.toType = toType;
	}

	@Column(name="to_type", nullable=true, length=255)	
	public String getToType() {
		return toType;
	}

	public void setRelationTypeGroup(String relationTypeGroup) {
		this.relationTypeGroup = relationTypeGroup;
	}

	@Column(name="relation_type_group", nullable=true, length=255)	
	public String getRelationTypeGroup() {
		return relationTypeGroup;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	@Column(name="relation_type", nullable=true, length=255)	
	public String getRelationType() {
		return relationType;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@Column(name="additional_info", nullable=true, length=0)	
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setOperatorUserId(Long operatorUserId) {
		this.operatorUserId = operatorUserId;
	}
	@Column(name="delete_flag", nullable=true, length=11)
	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
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
