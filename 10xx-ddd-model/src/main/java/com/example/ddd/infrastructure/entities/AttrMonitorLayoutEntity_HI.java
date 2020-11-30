package com.example.ddd.infrastructure.entities;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * AttrMonitorLayoutEntity_HI Entity Object
 * Fri May 29 16:49:31 CST 2020  Auto Generate
 */
@Entity
@Table(name="attr_monitor_layout")
public class AttrMonitorLayoutEntity_HI implements Serializable{
    private Long userId;
    private String tenantId;
    private String userName;
    private String layoutName; //布局名
    private String attrIds; //监视的属性ID，可多个
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date creationDate;
    private Long createdBy;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate;
    private Long lastUpdatedBy;
    private Integer versionNum;
    private Long operatorUserId;

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Id
	@GenericGenerator(name = "redisGenerationId", strategy = "com.sie.iot.common.idgenerate.RedisGenerationId")
	@GeneratedValue(generator = "redisGenerationId")
	@Column(name="user_id", nullable=false, length=31)
	public Long getUserId() {
		return userId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	@Column(name="tenant_id", nullable=false, length=31)	
	public String getTenantId() {
		return tenantId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="user_name", nullable=false, length=255)	
	public String getUserName() {
		return userName;
	}

	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}

	@Column(name="layout_name", nullable=false, length=255)	
	public String getLayoutName() {
		return layoutName;
	}

	public void setAttrIds(String attrIds) {
		this.attrIds = attrIds;
	}

	@Column(name="attr_ids", nullable=true, length=255)	
	public String getAttrIds() {
		return attrIds;
	}

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

	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}

	@Version
	@Column(name="version_num", nullable=true, length=11)	
	public Integer getVersionNum() {
		return versionNum;
	}

	public void setOperatorUserId(Long operatorUserId) {
		this.operatorUserId = operatorUserId;
	}

	@Transient	
	public Long getOperatorUserId() {
		return operatorUserId;
	}
}
