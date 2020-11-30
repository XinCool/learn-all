package com.example.ddd.infrastructure.entities.dto;


import java.io.Serializable;
import java.util.Objects;

/**
 * A Devicetype.
 */
public class Devicetype implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String description;
    private String devicetypeName;
    private Long parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public Devicetype description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDevicetypeName() {
        return devicetypeName;
    }

    public Devicetype devicetypeName(String devicetypeName) {
        this.devicetypeName = devicetypeName;
        return this;
    }

    public void setDevicetypeName(String devicetypeName) {
        this.devicetypeName = devicetypeName;
    }

    public Long getParentId() {
        return parentId;
    }

    public Devicetype parentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Devicetype devicetype = (Devicetype) o;
        if (devicetype.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), devicetype.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Devicetype{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", devicetypeName='" + getDevicetypeName() + "'" +
            ", parentId=" + getParentId() +
            "}";
    }
}
