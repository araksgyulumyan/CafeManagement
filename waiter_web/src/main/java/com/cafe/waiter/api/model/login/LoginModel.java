package com.cafe.waiter.api.model.login;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 5:40 PM
 */
public class LoginModel implements Serializable {

    private static final long serialVersionUID = -7029206687931922826L;

    // Properties
    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    // Constructors
    public LoginModel() {
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        LoginModel rhs = (LoginModel) obj;
        return new EqualsBuilder()
                .append(this.username, rhs.username)
                .append(this.password, rhs.password)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(username)
                .append(password)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("username", username)
                .append("password", password)
                .toString();
    }
}
