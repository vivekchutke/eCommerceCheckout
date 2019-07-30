package com.vivekchutke.microservice.product.productservice.entity;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name="Products")
public class Product extends CustomizedAuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long prodId;

    private String prodDesc;

    private BigDecimal price;

    private boolean available;

    private Integer availableQty;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", prodId=" + prodId +
                ", prodDesc='" + prodDesc + '\'' +
                ", price=" + price +
                ", available=" + available +
                ", availableQty=" + availableQty +
                '}';
    }

    public Product(Long prodId, String prodDesc, BigDecimal price, boolean available, int availableQty, Date created, Date updated) {
        this.prodId = prodId;
        this.prodDesc = prodDesc;
        this.price = price;
        this.available = available;
        this.availableQty = availableQty;
    }

    public Product() {

    }
}
