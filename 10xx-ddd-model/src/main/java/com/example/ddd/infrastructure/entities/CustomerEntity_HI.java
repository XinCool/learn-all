package com.example.ddd.infrastructure.entities;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * CustomerEntity_HI Entity Object
 * Fri Mar 27 15:41:16 CST 2020  Auto Generate
 */
@Entity
@Table(name="customer")
public class CustomerEntity_HI implements Serializable{
    private String id;
    private String additionalInfo;
    private String address;
    private String address2;
    private String city;
    private String country;
    private String email;
    private String phone;
    private String searchText;
    private String state;
    private String tenantId;
    private String title;
    private String zip;
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

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@Column(name="additional_info", nullable=true, length=0)	
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="address", nullable=true, length=0)	
	public String getAddress() {
		return address;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name="address2", nullable=true, length=0)	
	public String getAddress2() {
		return address2;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name="city", nullable=true, length=255)	
	public String getCity() {
		return city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name="country", nullable=true, length=255)	
	public String getCountry() {
		return country;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="email", nullable=true, length=255)	
	public String getEmail() {
		return email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name="phone", nullable=true, length=255)	
	public String getPhone() {
		return phone;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	@Column(name="search_text", nullable=true, length=255)	
	public String getSearchText() {
		return searchText;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name="state", nullable=true, length=255)	
	public String getState() {
		return state;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	@Column(name="tenant_id", nullable=true, length=31)	
	public String getTenantId() {
		return tenantId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="title", nullable=true, length=255)	
	public String getTitle() {
		return title;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name="zip", nullable=true, length=255)	
	public String getZip() {
		return zip;
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
