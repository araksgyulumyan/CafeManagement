package com.cafe.business.core.service.order;

import com.cafe.business.core.entity.order.Order;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 2:37 PM
 */
public interface OrderService {

    /**
     * Get order by id
     *
     * @param orderId
     * @return Order
     */
    Order getById(final Long orderId);

    /**
     * Opens order for provided table number
     *
     * @param tableNumber
     * @return Order
     */
    Order openOrder(final Integer tableNumber);


    /**
     * mark order as closed
     *
     * @param orderId
     * @return Order
     */
    Order closeOrder(final Long orderId);

    /**
     * mark order as canceled
     *
     * @param orderId
     * @return Order
     */
    Order cancelOrder(final Long orderId);

    /**
     * Adds product with provided quantity to order
     *
     * @param orderId
     * @param productId
     * @param quantity
     * @return Order
     */
    Order addProduct(final Long orderId, final Long productId, final Integer quantity);

    /**
     * Removes product from order
     *
     * @param orderId
     * @param productId
     * @return Order
     */
    Order removeProduct(final Long orderId, final Long productId);
}
