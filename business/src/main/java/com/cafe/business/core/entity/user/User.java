package com.cafe.business.core.entity.user;

import com.cafe.business.core.entity.common.BaseEntity;
import com.cafe.business.core.entity.table.CafeTable;
import com.cafe.business.core.service.user.common.UserRole;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 11:36 AM
 */

@Entity
@Table(name = "USERS")
public class User extends BaseEntity {

    private static final long serialVersionUID = 6385495562939818383L;

    // Properties
    @Column(name = "userName", nullable = false, unique = true)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, updatable = false)
    private UserRole userRole;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private CafeTable table;

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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public CafeTable getTable() {
        return table;
    }

    public void setTable(CafeTable table) {
        this.table = table;
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
        User rhs = (User) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.userName, rhs.userName)
                .append(this.password, rhs.password)
                .append(this.firstName, rhs.firstName)
                .append(this.lastName, rhs.lastName)
                .append(this.userRole, rhs.userRole)
                .append(BaseEntity.getIdOrNull(this.table), BaseEntity.getIdOrNull(rhs.table))
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
                .append(userRole)
                .append(BaseEntity.getIdOrNull(table))
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
                .append("userRole", userRole)
                .append("table", BaseEntity.getIdOrNull(table))
                .toString();
    }
}
