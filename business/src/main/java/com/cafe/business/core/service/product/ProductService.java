package com.cafe.business.core.service.product;

import com.cafe.business.core.entity.product.Product;

import java.math.BigDecimal;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 2:31 PM
 */

public interface ProductService {

    /**
     * Creates product
     *
     * @param name
     * @param price
     * @return Product
     */
    Product createProduct(final String name, final BigDecimal price);

    /**
     * Get product by provided id
     *
     * @param productId
     * @return Product
     */
    Product getProductById(final Long productId);
}
