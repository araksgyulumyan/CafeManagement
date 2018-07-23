package com.cafe.manager.api.model.common.response;

import com.cafe.manager.api.model.common.response.error.ErrorType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 3:12 PM
 */
public abstract class AbstractResponseModel implements Serializable {

    private static final long serialVersionUID = -5998448257434102507L;

    // Properties
    private Long id;

    private Date created;

    private Date updated;

    private List<ErrorType> errors;

    // Constructors
    public AbstractResponseModel() {
    }

    public AbstractResponseModel(Long id, Date created, Date updated) {
        this.id = id;
        this.created = created;
        this.updated = updated;
    }

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

    public List<ErrorType> getErrors() {
        if (Objects.isNull(errors)) {
            errors = new ArrayList<>();
        }
        return errors;
    }

    public void setErrors(List<ErrorType> errors) {
        this.errors = errors;
    }

    // Utility methods
    public boolean hasErrors() {
        return getErrors().size() > 0;
    }

    protected void addErrors(final List<ErrorType> errors) {
        getErrors().addAll(errors);
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
        AbstractResponseModel rhs = (AbstractResponseModel) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.created, rhs.created)
                .append(this.updated, rhs.updated)
                .append(this.errors, rhs.errors)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(created)
                .append(updated)
                .append(errors)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("created", created)
                .append("updated", updated)
                .append("errors", errors)
                .toString();
    }
}
