package com.cafe.manager.api.model.response.user;

import com.cafe.business.core.entity.user.User;
import com.cafe.manager.api.model.common.response.AbstractResponseModel;
import com.cafe.manager.api.model.common.response.error.ErrorType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 3:11 PM
 */
public class UserResponseModel extends AbstractResponseModel {

    private static final long serialVersionUID = -8188637880721289970L;

    // Properties
    private String userName;

    private String firstName;

    private String lastName;

    private Timestamp updated;

    // Constructors
    public UserResponseModel() {
    }

    public UserResponseModel(Long id, String userName, String firstName, String lastName, Date created, Date updated) {
        super(id, created, updated);
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Utility methods
    public static UserResponseModel fromUser(final User user) {
        final UserResponseModel model = new UserResponseModel();
        model.setId(user.getId());
        model.setFirstName(user.getFirstName());
        model.setLastName(user.getLastName());
        model.setUserName(user.getUserName());
        model.setCreated(user.getCreated());
        model.setUpdated(user.getUpdated());
        return model;
    }

    public static UserResponseModel withErrors(final List<ErrorType> errors) {
        UserResponseModel model = new UserResponseModel();
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
        UserResponseModel rhs = (UserResponseModel) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.userName, rhs.userName)
                .append(this.firstName, rhs.firstName)
                .append(this.lastName, rhs.lastName)
                .append(this.updated, rhs.updated)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(userName)
                .append(firstName)
                .append(lastName)
                .append(updated)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("userName", userName)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("updated", updated)
                .toString();
    }
}
