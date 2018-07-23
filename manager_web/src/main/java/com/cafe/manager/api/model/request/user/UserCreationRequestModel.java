package com.cafe.manager.api.model.request.user;

import com.cafe.manager.api.model.common.request.AbstractRequestModel;
import com.cafe.manager.api.validation.UniqueUsername;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotEmpty;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 3:11 PM
 */
public class UserCreationRequestModel extends AbstractRequestModel {

    private static final long serialVersionUID = 5781608032570295051L;

    // Properties
    @NotEmpty
    @UniqueUsername
    private String userName;

    @NotEmpty
    private String password;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    // Getters and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
        UserCreationRequestModel rhs = (UserCreationRequestModel) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.userName, rhs.userName)
                .append(this.password, rhs.password)
                .append(this.firstName, rhs.firstName)
                .append(this.lastName, rhs.lastName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(userName)
                .append(password)
                .append(firstName)
                .append(lastName)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("userName", userName)
                .append("password", password)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .toString();
    }
}
