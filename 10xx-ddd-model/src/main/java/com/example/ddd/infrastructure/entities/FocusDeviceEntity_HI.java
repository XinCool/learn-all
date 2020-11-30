package com.example.ddd.infrastructure.entities;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * FocusDeviceEntity_HI Entity Object
 * Tue Jun 02 14:33:33 CST 2020  Auto Generate
 */
@Entity
@Table(name="focus_device")
public class FocusDeviceEntity_HI implements Serializable{
    private String id;
    private Long userId; //用户ID
    private String deviceName; //设备名
    private String producer; //生产厂家
    private String deviceId; //设备编号
    private String photoUri; //设备图片路径
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date creationDate;
    private Long createdBy;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate;
    private Long lastUpdatedBy;
    private Integer versionNum;
    private Long operatorUserId;

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "com.example.ddd.infrastructure.utils.id.CustomUUIDGenerator")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="id", nullable=false, length=31)	
	public String getId() {
		return id;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name="user_id", nullable=true, length=20)	
	public Long getUserId() {
		return userId;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	@Column(name="device_name", nullable=true, length=255)	
	public String getDeviceName() {
		return deviceName;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	@Column(name="producer", nullable=true, length=500)	
	public String getProducer() {
		return producer;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Column(name="device_id", nullable=true, length=31)	
	public String getDeviceId() {
		return deviceId;
	}

	public void setPhotoUri(String photoUri) {
		this.photoUri = photoUri;
	}

	@Column(name="photo_uri", nullable=true, length=500)	
	public String getPhotoUri() {
		return photoUri;
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
