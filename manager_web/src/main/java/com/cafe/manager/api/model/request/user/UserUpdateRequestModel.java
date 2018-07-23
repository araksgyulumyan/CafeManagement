package com.cafe.manager.api.model.request.user;

import com.cafe.manager.api.model.common.request.AbstractRequestModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotEmpty;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 3:11 PM
 */
public class UserUpdateRequestModel extends AbstractRequestModel {

    private static final long serialVersionUID = -5236782510985574302L;

    // Properties
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    // Constructor
    public UserUpdateRequestModel() {
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        UserUpdateRequestModel rhs = (UserUpdateRequestModel) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.firstName, rhs.firstName)
                .append(this.lastName, rhs.lastName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(firstName)
                .append(lastName)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("firstName", firstName)
                .append("lastName", lastName)
                .toString();
    }
}
