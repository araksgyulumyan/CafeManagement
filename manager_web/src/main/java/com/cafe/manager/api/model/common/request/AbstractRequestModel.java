package com.cafe.manager.api.model.common.request;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 3:12 PM
 */
public abstract class AbstractRequestModel implements Serializable {

    private static final long serialVersionUID = -812661755447231327L;

    // Constructors
    public AbstractRequestModel() {
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
        AbstractRequestModel rhs = (AbstractRequestModel) obj;
        return new EqualsBuilder()
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .toString();
    }
}
