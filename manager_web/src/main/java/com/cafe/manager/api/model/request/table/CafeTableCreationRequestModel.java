package com.cafe.manager.api.model.request.table;

import com.cafe.manager.api.model.common.request.AbstractRequestModel;
import com.cafe.manager.api.validation.UniqueTableNumber;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 6:08 PM
 */
public class CafeTableCreationRequestModel extends AbstractRequestModel {

    // Properties
    @NotNull
    @UniqueTableNumber
    private Integer tableNumber;

    // Getters and Setters
    public Integer getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
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
        CafeTableCreationRequestModel rhs = (CafeTableCreationRequestModel) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.tableNumber, rhs.tableNumber)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(tableNumber)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("tableNumber", tableNumber)
                .toString();
    }
}
