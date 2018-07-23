package com.cafe.business.core.repository.order;

import com.cafe.business.core.entity.order.Order;
import com.cafe.business.core.service.order.common.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 12:53 PM
 */

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    /**
     * Finds all order with provided order status
     *
     * @param orderStatus
     * @return List of orders
     */
    List<Order> findAllByStatus(final OrderStatus orderStatus);
}
