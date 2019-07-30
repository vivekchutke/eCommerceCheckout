package com.vivekchutke.microservise.checkout.pcfcheckoutservice.repository;

import com.vivekchutke.microservise.checkout.pcfcheckoutservice.bean.ProductDetails;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RibbonClient("pcf-product-service")
@FeignClient(name="pcf-product-service")
//@FeignClient(name="pcf-product-service", url = "http://localhost:8080")
public interface ProductRepository {

    @GetMapping("/product")
    public List<ProductDetails> retrieveProductsDetails(@RequestParam(name="products") List<Long> productIds);

}
