package com.cafe.manager.api.model.response.table;

import com.cafe.business.core.entity.table.CafeTable;
import com.cafe.manager.api.model.common.response.AbstractResponseModel;
import com.cafe.manager.api.model.common.response.error.ErrorType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 6:17 PM
 */
public class CafeTableResponseModel extends AbstractResponseModel {

    // Properties
    private Integer tableNumber;

    // Constructors
    public CafeTableResponseModel() {
    }

    // Getters and Setters
    public Integer getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }

    // Utility methods
    public static CafeTableResponseModel fromTable(final CafeTable cafeTable) {
        final CafeTableResponseModel model = new CafeTableResponseModel();
        model.setId(cafeTable.getId());
        model.setTableNumber(cafeTable.getNumber());
        model.setCreated(cafeTable.getCreated());
        model.setUpdated(cafeTable.getUpdated());
        return model;
    }

    public static CafeTableResponseModel withErrors(final List<ErrorType> errors) {
        CafeTableResponseModel model = new CafeTableResponseModel();
        model.addErrors(errors);
        return model;
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
        CafeTableResponseModel rhs = (CafeTableResponseModel) obj;
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
