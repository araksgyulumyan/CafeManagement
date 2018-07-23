package com.cafe.business.core.entity.common;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 11:35 AM
 */

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 2209851511542165964L;

    // Properties
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created")
    @CreationTimestamp
    private Date created;

    @Column(name = "updated")
    @CreationTimestamp
    private Date updated;

    @Column
    private Date removed;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getRemoved() {
        return removed;
    }

    public void setRemoved(Date removed) {
        this.removed = removed;
    }

    public static Long getIdOrNull(final BaseEntity baseEntity) {
        return Objects.isNull(baseEntity) ? null : baseEntity.getId();
    }

    // Equals, HashCode and ToString
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        BaseEntity rhs = (BaseEntity) obj;
        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.created, rhs.created)
                .append(this.updated, rhs.updated)
                .append(this.removed, rhs.removed)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder()
                .append(id)
                .append(created)
                .append(updated)
                .append(removed)
                .toHashCode();
    }
}
