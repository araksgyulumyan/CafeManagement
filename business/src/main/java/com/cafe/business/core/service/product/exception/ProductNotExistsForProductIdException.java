package com.cafe.business.core.service.product.exception;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 2:36 PM
 */
public class ProductNotExistsForProductIdException extends RuntimeException {

    private static final long serialVersionUID = 361582269286015263L;

    // Properties
    private Long productId;

    public ProductNotExistsForProductIdException(Long productId) {
        super(String.format("Product with id %d not exists", productId));
        this.productId = productId;
    }

    // Getters
    public Long getProductId() {
        return productId;
    }
}
