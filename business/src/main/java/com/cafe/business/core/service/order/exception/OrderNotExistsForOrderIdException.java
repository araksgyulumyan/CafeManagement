package com.cafe.business.core.service.order.exception;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 2:41 PM
 */
public class OrderNotExistsForOrderIdException extends RuntimeException {

    private static final long serialVersionUID = -7568449873262587155L;

    // Properties
    private Long orderId;

    public OrderNotExistsForOrderIdException(Long orderId) {
        super(String.format("Order with id %d not exists", orderId));
        this.orderId = orderId;
    }

    // Getters
    public Long getOrderId() {
        return orderId;
    }
}
