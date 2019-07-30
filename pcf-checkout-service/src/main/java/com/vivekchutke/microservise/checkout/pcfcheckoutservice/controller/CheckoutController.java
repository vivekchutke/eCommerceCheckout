package com.vivekchutke.microservise.checkout.pcfcheckoutservice.controller;

import com.vivekchutke.microservise.checkout.pcfcheckoutservice.bean.ProductDetails;
import com.vivekchutke.microservise.checkout.pcfcheckoutservice.exception.ProductNotFoundException;
import com.vivekchutke.microservise.checkout.pcfcheckoutservice.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckoutController {

    Logger logger = LoggerFactory.getLogger(CheckoutController.class);

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/checkout")
    public List<ProductDetails> getProductInfo(@RequestParam(name = "products") List<Long> productIds) {

        logger.info("Requested ProductId's are: "+productIds);

        List<ProductDetails> products = productRepository.retrieveProductsDetails(productIds);

        if(products.isEmpty()) {
            throw new ProductNotFoundException("Something went wrong. We where not able to retrieve the required product information:");
        }
        logger.info("Product Id's are: "+products);

        return products;
    }


}
