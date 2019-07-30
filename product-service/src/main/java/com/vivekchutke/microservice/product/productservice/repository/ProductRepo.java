package com.vivekchutke.microservice.product.productservice.repository;

import com.vivekchutke.microservice.product.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    public static final String FIND_PRODUCTS = "SELECT * FROM products where prod_id in (:productIds)";

    public Product findByProdId(Long prodId);

    public Product findByProdIdAndAvailableQty(Long prodId, Integer Qty);

    @Query(value = FIND_PRODUCTS, nativeQuery = true)
    public List<Product> findAllByProdId(@Param("productIds") List<Long> productIds);

}
