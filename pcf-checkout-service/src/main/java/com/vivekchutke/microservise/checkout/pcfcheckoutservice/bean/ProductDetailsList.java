package com.vivekchutke.microservise.checkout.pcfcheckoutservice.bean;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsList {

    private List<ProductDetails> products;

    public ProductDetailsList() {
        products = new ArrayList<ProductDetails>();
    }

    public List<ProductDetails> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDetails> products) {
        this.products = products;
    }
}
