package com.cafe.business.core.repository.product;

import com.cafe.business.core.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 12:52 PM
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Finds product with provided productName
     *
     * @param productName
     * @return Product
     */
    Product findByName(final String productName);
}
