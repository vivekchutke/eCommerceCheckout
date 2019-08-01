package com.vivekchutke.microservice.product.productservice.controller;

import com.vivekchutke.microservice.product.productservice.entity.Product;
import com.vivekchutke.microservice.product.productservice.exception.ProductException;
import com.vivekchutke.microservice.product.productservice.exception.ProductNotFoundException;
import com.vivekchutke.microservice.product.productservice.repository.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private Environment environment;

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/products")
    public List<Product> retrieveAllProducts() {

        logger.info("In retrieve products List:");
        List<Product> products = productRepo.findAll();

//        logger.info("#### Port Information is: "+environment.getProperty("local.server.port"));
        logger.info("#### Printing Blue VCAP_Application Details: "+environment.getProperty("VCAP_Application"));

        if(products != null && products.isEmpty())
        {
            logger.error("Something went wrong with fetching the List of products:");
            throw new ProductNotFoundException("Product Not found exception: ");
        }
        return productRepo.findAll();
    }

    @PostMapping("/product")
    public Product saveNewProducts(@RequestBody Product product) {
        logger.info("Into the logger class to save the new product");
        Product savedProd = productRepo.save(product);
        return savedProd;
    }

    @GetMapping("/product/{productId}")
    public Product retrieveByProductId(@PathVariable Long productId) {
        logger.info("Retrieve a product by ProductId: "+productId);
        Product product = productRepo.findByProdId(productId);
        if(product == null)
        {
            logger.error("Something went wrong with fetching the List of products:");
            throw new ProductNotFoundException("Product Not found exception: ");
        }

        return product;
    }

    @GetMapping("/product")
    public List<Product> retrieveProducts(@RequestParam(name = "products") List<Long> productsIds) {
        logger.info("Retrieving product information for the following products: "+productsIds);
        List<Product> products = productRepo.findAllByProdId(productsIds);

        if(products != null && products.isEmpty())
        {
            logger.error("Something went wrong with fetching the List of products:"+products);
            throw new ProductNotFoundException("Product Not found exception: ");
        }
        return products;
    }

    @GetMapping("/product/{productId}/qty/{qty}")
    public Product retrieveByProductIdAndQty(@PathVariable Long productId,  @PathVariable Integer qty) {
        logger.info("Retrieve a product by ProductId: "+productId);
        logger.info("Retrieve a product by ProductId and Qty"+qty);
        Product product = productRepo.findByProdIdAndAvailableQty(productId, qty);
        if(product == null)
        {
            logger.error("Something went wrong with fetching the product by ProductId and Qty:");
            throw new ProductNotFoundException("Product Not found exception: ");
        }

        return product;
    }

    public ProductController(){
        logger.info("In product controller:");
    }
}
