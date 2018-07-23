package com.cafe.business.core.service.product.impl;

import com.cafe.business.core.entity.product.Product;
import com.cafe.business.core.repository.product.ProductRepository;
import com.cafe.business.core.service.product.ProductService;
import com.cafe.business.core.service.product.exception.ProductAlreadyExistsForNameException;
import com.cafe.business.core.service.product.exception.ProductNotExistsForProductIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 2:32 PM
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Product createProduct(final String name, final BigDecimal price) {
        assertName(name);
        assertPrice(price);
        checkIfProductAlreadyExistsForName(name);
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product = productRepository.save(product);
        return product;
    }

    @Override
    public Product getProductById(final Long productId) {
        assertId(productId);
        Product product = productRepository.findById(productId).get();
        assertProductNotNullForProductId(productId, product);
        return product;
    }

    // Utility methods
    private static void assertName(final String name) {
        Assert.hasText(name, "Product name should not be empty");
    }

    private static void assertPrice(final BigDecimal price) {
        Assert.notNull(price, "Product price should not be null");
    }

    private static void assertId(final Long productId) {
        Assert.notNull(productId, "Product id should not be null");
    }

    private void assertProductNotNullForProductId(final Long productId, final Product product) {
        if (product == null) {
            throw new ProductNotExistsForProductIdException(productId);
        }
    }

    private void checkIfProductAlreadyExistsForName(final String productName) {
        Product product = productRepository.findByName(productName);
        if (Objects.nonNull(product)) {
            throw new ProductAlreadyExistsForNameException(productName);
        }
    }
}
