package com.cafe.business.core.service.product.exception;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 2:36 PM
 */
public class ProductAlreadyExistsForNameException extends RuntimeException {

    private static final long serialVersionUID = -628858888929468608L;

    // Properties
    private String productName;

    public ProductAlreadyExistsForNameException(final String productName) {
        super(String.format("Product with name %s already exists", productName));
    }

    // Getters
    public String getProductName() {
        return productName;
    }
}
