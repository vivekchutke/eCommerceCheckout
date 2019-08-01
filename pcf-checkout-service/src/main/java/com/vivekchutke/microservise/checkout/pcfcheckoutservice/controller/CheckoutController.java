package com.vivekchutke.microservise.checkout.pcfcheckoutservice.controller;

import com.vivekchutke.microservise.checkout.pcfcheckoutservice.bean.ProductDetails;
import com.vivekchutke.microservise.checkout.pcfcheckoutservice.exception.ProductNotFoundException;
import com.vivekchutke.microservise.checkout.pcfcheckoutservice.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CheckoutController {

    Logger logger = LoggerFactory.getLogger(CheckoutController.class);

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/checkout")
    public List<ProductDetails> calculateOrderTotalFeign(@RequestParam(name = "products") List<Long> productIds) {

        logger.info("Requested ProductId's are: "+productIds);

        List<ProductDetails> products = productRepository.retrieveProductsDetails(productIds);

        if(products.isEmpty()) {
            throw new ProductNotFoundException("Something went wrong. We where not able to retrieve the required product information:");
        }
        logger.info("Product Id's are: "+products);

        return products;
    }


//    /**
//     * Traditional way of making a Rest Call without Feign and Client Side load balancer Ribbon
//     *
//     */
//    public List<ProductDetails> calculateOrderTotalLegacyMethod(@RequestParam(name = "products") List<Long> products) {
//        logger.info("Calculating the Ordertotal for the given products using legacy way of making an external service call");
//
//        Map<String, List<Long>> uriVariable = new HashMap<String, List<Long>>();
//        uriVariable.put("products", products);
//
////        ResponseEntity<CurrencyConverstionBean> responseEntity =
////                new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
////                        CurrencyConverstionBean.class, uriVariables);
//
//        ResponseEntity<List<ProductDetails>> responseEntity = new RestTemplate().getForEntity("", ArrayList.class, uriVariable );
//        return null;
//
//    }


    @GetMapping("/product/{productId}")
    public ProductDetails getProductInfo(@PathVariable Long productId) {

        logger.info("In getProductInfo class from checkout Microservice: "+productId);
        Map<String, Long> uriVariable = new HashMap<String, Long>();
        uriVariable.put("productId", productId);

        ResponseEntity<ProductDetails> productDetailsResponseEntity =
                new RestTemplate().getForEntity("http://localhost:8080/product/{productId}", ProductDetails.class, uriVariable);

        ProductDetails productDetails = productDetailsResponseEntity.getBody();
        return productDetails;
    }

}
