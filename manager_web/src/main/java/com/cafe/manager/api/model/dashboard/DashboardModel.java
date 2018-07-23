package com.cafe.manager.api.model.dashboard;

import com.cafe.manager.api.model.response.table.CafeTableResponseModel;
import com.cafe.manager.api.model.response.user.UserResponseModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 3:11 PM
 */
public class DashboardModel implements Serializable {

    private static final long serialVersionUID = -2698579076426564112L;

    // Properties
    private Set<UserResponseModel> waiters;

    private UserResponseModel manager;

    private Set<CafeTableResponseModel> tables;

    // Constructors
    public DashboardModel() {
    }

    public DashboardModel(Set<UserResponseModel> waiters, UserResponseModel manager, Set<CafeTableResponseModel> tables) {
        this.waiters = waiters;
        this.manager = manager;
        this.tables = tables;
    }

    // Getters and setters
    public Set<UserResponseModel> getWaiters() {
        return waiters;
    }

    public void setWaiters(Set<UserResponseModel> waiters) {
        Comparator<UserResponseModel> comp = (UserResponseModel t1, UserResponseModel t2) -> (t1.getCreated().compareTo(t2.getCreated()));
        if (waiters == null) {
            waiters = new TreeSet<>(comp);
        }
        this.waiters = waiters;
    }

    public UserResponseModel getManager() {
        return manager;
    }

    public void setManager(UserResponseModel manager) {
        this.manager = manager;
    }

    public Set<CafeTableResponseModel> getTables() {
        return tables;
    }

    public void setTables(Set<CafeTableResponseModel> tables) {
        Comparator<CafeTableResponseModel> comp = (CafeTableResponseModel t1, CafeTableResponseModel t2) -> (t1.getCreated().compareTo(t2.getCreated()));
        if (tables == null) {
            tables = new TreeSet<>(comp);
        }
        this.tables = tables;
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
        DashboardModel rhs = (DashboardModel) obj;
        return new EqualsBuilder()
                .append(this.waiters, rhs.waiters)
                .append(this.manager, rhs.manager)
                .append(this.tables, rhs.tables)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(waiters)
                .append(manager)
                .append(tables)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("waiters", waiters)
                .append("manager", manager)
                .append("tables", tables)
                .toString();
    }
}

