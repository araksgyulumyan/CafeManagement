package com.cafe.business.core.entity.product;

import com.cafe.business.core.entity.common.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 11:58 AM
 */

@Entity
@Table(name = "PRODUCTS")
public class Product extends BaseEntity {

    private static final long serialVersionUID = -4163815135364030582L;

    // Properties
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductInOrder> orders;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<ProductInOrder> getOrders() {
        if (orders == null) {
            orders = new ArrayList<>();
        }
        return orders;
    }

    public void setOrders(List<ProductInOrder> orders) {
        this.orders = orders;
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
        Product rhs = (Product) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.name, rhs.name)
                .append(this.price, rhs.price)
                .append(this.orders.size(), rhs.orders.size())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(name)
                .append(price)
                .append(orders.size())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("name", name)
                .append("price", price)
                .append("orders", orders.size())
                .toString();
    }
}
