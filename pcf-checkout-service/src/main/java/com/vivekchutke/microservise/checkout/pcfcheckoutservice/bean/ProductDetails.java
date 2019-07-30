package com.vivekchutke.microservise.checkout.pcfcheckoutservice.bean;

import java.math.BigDecimal;

public class ProductDetails {

    private Long prodId;

    private String prodDesc;

    private BigDecimal price;

    private boolean available;

    private Integer availableQty;

    public ProductDetails() {

    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "prodId=" + prodId +
                ", prodDesc='" + prodDesc + '\'' +
                ", price=" + price +
                ", available=" + available +
                ", availableQty=" + availableQty +
                '}';
    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Integer getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(Integer availableQty) {
        this.availableQty = availableQty;
    }
}
