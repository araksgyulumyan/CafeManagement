package com.cafe.business.core.entity.table;

import com.cafe.business.core.entity.common.BaseEntity;
import com.cafe.business.core.entity.user.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 11:48 AM
 */

@Entity
@Table(name = "TABLES")
public class CafeTable extends BaseEntity {

    private static final long serialVersionUID = 4656800336698999862L;

    // Properties
    @Column(name = "number", nullable = false, unique = true)
    private Integer number;

    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    // Getters and Setters
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        CafeTable rhs = (CafeTable) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.number, rhs.number)
                .append(BaseEntity.getIdOrNull(this.user), BaseEntity.getIdOrNull(rhs.user))
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(number)
                .append(BaseEntity.getIdOrNull(user))
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("number", number)
                .append("user", BaseEntity.getIdOrNull(user))
                .toString();
    }
}
