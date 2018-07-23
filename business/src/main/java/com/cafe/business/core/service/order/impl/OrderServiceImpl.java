package com.cafe.business.core.service.order.impl;

import com.cafe.business.core.entity.order.Order;
import com.cafe.business.core.entity.product.Product;
import com.cafe.business.core.entity.product.ProductInOrder;
import com.cafe.business.core.entity.table.CafeTable;
import com.cafe.business.core.repository.order.OrderRepository;
import com.cafe.business.core.service.order.OrderService;
import com.cafe.business.core.service.order.common.OrderStatus;
import com.cafe.business.core.service.order.exception.OrderNotExistsForOrderIdException;
import com.cafe.business.core.service.product.ProductService;
import com.cafe.business.core.service.table.CafeTableService;
import com.cafe.business.core.service.table.exception.TableAlreadyAssignedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 2:37 PM
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CafeTableService cafeTableService;

    @Autowired
    private ProductService productService;

    @Override
    public Order getById(final Long orderId) {
        assertOrderId(orderId);
        final Order order = orderRepository.findById(orderId).get();
        assertOrderNotNullForOrderId(orderId, order);
        return order;
    }

    @Override
    @Transactional
    public Order openOrder(final Integer tableNumber) {
        assertTableNumber(tableNumber);
        final CafeTable table = cafeTableService.getTableByNumber(tableNumber);
        assertTableIsAlreadyAssignedToUser(tableNumber, table);
        Order order = new Order();
        order.setTable(table);
        order = orderRepository.save(order);
        return order;
    }

    @Override
    @Transactional
    public Order closeOrder(final Long orderId) {
        assertOrderId(orderId);
        Order order = getById(orderId);
        order.setStatus(OrderStatus.CLOSED);
        order = orderRepository.save(order);
        assertTableIsNotNullForOrder(order);
        cafeTableService.unassignTableFromUser(order.getTable().getNumber());
        return order;
    }

    @Override
    @Transactional
    public Order cancelOrder(final Long orderId) {
        assertOrderId(orderId);
        Order order = getById(orderId);
        order.setStatus(OrderStatus.CANCELLED);
        order = orderRepository.save(order);
        assertTableIsNotNullForOrder(order);
        cafeTableService.unassignTableFromUser(order.getTable().getNumber());
        return order;
    }

    @Override
    @Transactional
    public Order addProduct(final Long orderId, final Long productId, final Integer quantity) {
        assertOrderId(orderId);
        assertProductId(productId);
        assertQuantity(quantity);
        Product product = productService.getProductById(productId);
        Order order = getById(orderId);
        ProductInOrder productInOrder = new ProductInOrder(order, product, quantity);
        order.getProducts().add(productInOrder);
        orderRepository.save(order);
        return order;
    }

    @Override
    @Transactional
    public Order removeProduct(final Long orderId, final Long productId) {
        assertOrderId(orderId);
        assertProductId(productId);
        Order order = getById(orderId);
        List<ProductInOrder> productsInOrder = order.getProducts();
        final Iterator<ProductInOrder> iterator = order.getProducts().iterator();
        while (iterator.hasNext()) {
            ProductInOrder productInOrder = iterator.next();
            if (productId.equals(productInOrder.getProduct().getId())) {
                iterator.remove();
            }
        }
        for (ProductInOrder productInOrder : productsInOrder) {
            if (productId.equals(productInOrder.getProduct().getId())) {
                productInOrder.setOrder(null);
                productInOrder.setProduct(null);
                order.getProducts().remove(productInOrder);
            }
        }
        orderRepository.save(order);
        return order;
    }

    // Utility methods
    private static void assertTableNumber(final Integer tableNumber) {
        Assert.notNull(tableNumber, "Table number should not be null");
    }

    private static void assertProductId(final Long productId) {
        Assert.notNull(productId, "Product id should not be null");
    }

    private static void assertQuantity(final Integer quantity) {
        Assert.notNull(quantity, "Quantity should not be null");
    }

    private void assertOrderNotNullForOrderId(final Long orderId, final Order order) {
        if (order == null) {
            throw new OrderNotExistsForOrderIdException(orderId);
        }
    }

    private static void assertOrderId(final Long orderId) {
        Assert.notNull(orderId, "Order id should not be null");
    }

    private static void assertTableIsAlreadyAssignedToUser(final Integer tableNumber, final CafeTable cafeTable) {
        if (Objects.nonNull(cafeTable.getUser())) {
            throw new TableAlreadyAssignedException(tableNumber);
        }
    }

    private static void assertTableIsNotNullForOrder(final Order order) {
        if (Objects.isNull(order.getTable())) {
            throw new RuntimeException(String.format("Table is null for order with id %d", order.getId()));
        }
    }
}
