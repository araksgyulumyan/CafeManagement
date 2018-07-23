package com.cafe.business.core.entity.product;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 12:08 PM
 */

@Embeddable
public class ProductInOrderId implements Serializable {

    private static final long serialVersionUID = -1852367306514852850L;

    // Properties
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;

    // Constructors
    public ProductInOrderId() {
    }

    public ProductInOrderId(Long orderId, Long productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
        ProductInOrderId rhs = (ProductInOrderId) obj;
        return new EqualsBuilder()
                .append(this.orderId, rhs.orderId)
                .append(this.productId, rhs.productId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(orderId)
                .append(productId)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("orderId", orderId)
                .append("productId", productId)
                .toString();
    }
}
