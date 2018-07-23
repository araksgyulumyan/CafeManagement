package com.cafe.business.core.entity.order;

import com.cafe.business.core.entity.common.BaseEntity;
import com.cafe.business.core.entity.product.ProductInOrder;
import com.cafe.business.core.entity.table.CafeTable;
import com.cafe.business.core.service.order.common.OrderStatus;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 12:02 PM
 */

@Entity
@Table(name = "ORDERS")
public class Order extends BaseEntity {

    private static final long serialVersionUID = 5488790244363822634L;

    // Properties
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "table_id", nullable = false)
    private CafeTable table;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductInOrder> products;

    // Constructors
    public Order() {
        setStatus(OrderStatus.OPEN);
    }

    // Getters and Setters
    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public CafeTable getTable() {
        return table;
    }

    public void setTable(CafeTable table) {
        this.table = table;
    }

    public List<ProductInOrder> getProducts() {
        if (products == null) {
            products = new ArrayList<>();
        }
        return products;
    }

    public void setProducts(List<ProductInOrder> products) {
        this.products = products;
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
        Order rhs = (Order) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.status, rhs.status)
                .append(BaseEntity.getIdOrNull(this.table), BaseEntity.getIdOrNull(rhs.table))
                .append(this.products.size(), rhs.products.size())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(status)
                .append(table)
                .append(products.size())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("status", status)
                .append("table", table)
                .append("products", products.size())
                .toString();
    }
}
