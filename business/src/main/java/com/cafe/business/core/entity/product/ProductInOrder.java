package com.cafe.business.core.entity.product;

import com.cafe.business.core.entity.common.BaseEntity;
import com.cafe.business.core.entity.order.Order;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 12:12 PM
 */

@Entity
@Table(name = "PRODUCTS_IN_ORDER")
public class ProductInOrder implements Serializable {

    private static final long serialVersionUID = 2005022548457431003L;

    // Properties
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("product_id")
    private Product product;

    @EmbeddedId
    private ProductInOrderId productInOrderId;

    // Constructors
    public ProductInOrder() {
    }

    public ProductInOrder(Order order, Product product, Integer quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.productInOrderId = new ProductInOrderId(order.getId(), product.getId());
    }

    // Getters and Setters
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductInOrderId getProductInOrderId() {
        return productInOrderId;
    }

    public void setProductInOrderId(ProductInOrderId productInOrderId) {
        this.productInOrderId = productInOrderId;
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
        ProductInOrder rhs = (ProductInOrder) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.quantity, rhs.quantity)
                .append(BaseEntity.getIdOrNull(this.order), BaseEntity.getIdOrNull(rhs.order))
                .append(BaseEntity.getIdOrNull(this.product), BaseEntity.getIdOrNull(rhs.product))
                .append(this.productInOrderId, rhs.productInOrderId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(quantity)
                .append(BaseEntity.getIdOrNull(order))
                .append(BaseEntity.getIdOrNull(product))
                .append(productInOrderId)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("quantity", quantity)
                .append("order", BaseEntity.getIdOrNull(order))
                .append("product", BaseEntity.getIdOrNull(product))
                .append("productInOrderId", productInOrderId)
                .toString();
    }
}
