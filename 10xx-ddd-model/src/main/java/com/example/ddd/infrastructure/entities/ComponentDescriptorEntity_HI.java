package com.example.ddd.infrastructure.entities;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * ComponentDescriptorEntity_HI Entity Object
 * Fri Mar 27 15:41:15 CST 2020  Auto Generate
 */
@Entity
@Table(name="component_descriptor")
public class ComponentDescriptorEntity_HI implements Serializable{
    private String id;
    private String actions;
    private String clazz;
    private String configurationDescriptor;
    private String name;
    private String scope;
    private String searchText;
    private String type;
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

	public void setActions(String actions) {
		this.actions = actions;
	}

	@Column(name="actions", nullable=true, length=255)	
	public String getActions() {
		return actions;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	@Column(name="clazz", nullable=true, length=0)	
	public String getClazz() {
		return clazz;
	}

	public void setConfigurationDescriptor(String configurationDescriptor) {
		this.configurationDescriptor = configurationDescriptor;
	}

	@Column(name="configuration_descriptor", nullable=true, length=0)	
	public String getConfigurationDescriptor() {
		return configurationDescriptor;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="name", nullable=true, length=255)	
	public String getName() {
		return name;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	@Column(name="scope", nullable=true, length=255)	
	public String getScope() {
		return scope;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	@Column(name="search_text", nullable=true, length=255)	
	public String getSearchText() {
		return searchText;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="type", nullable=true, length=255)	
	public String getType() {
		return type;
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
	private Integer deleteFlag; //删除标识 0表示未删除 1表示删除了

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name="creation_date", nullable=true, length=0)
	public Date getCreationDate() {
		return creationDate;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name="delete_flag", nullable=true, length=11)
	public Integer getDeleteFlag() {
		return deleteFlag;
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
