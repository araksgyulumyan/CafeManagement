package com.cafe.business.core.service.user.dto;

import com.cafe.business.core.entity.user.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 12:57 PM
 */
public class UserDto {

    // Properties
    private String firstName;

    private String lastName;

    // Constructor
    public UserDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserDto() {
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

    // Utility methods
    public void updateDomainModelProperties(final User user) {
        if (user != null) {
            user.setFirstName(this.getFirstName());
            user.setLastName(this.getLastName());
        }
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
        UserDto rhs = (UserDto) obj;
        return new EqualsBuilder()
                .append(this.firstName, rhs.firstName)
                .append(this.lastName, rhs.lastName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(firstName)
                .append(lastName)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .toString();
    }
}
