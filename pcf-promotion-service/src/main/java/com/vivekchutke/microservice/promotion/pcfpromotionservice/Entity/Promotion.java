package com.vivekchutke.microservice.promotion.pcfpromotionservice.Entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@EnableJpaAuditing
//@XmlRootElement
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long promotionId;

    private String promotionName;

    private String promotionDescription;

    private String promoCode;

    private String insertedBy;

    @CreationTimestamp
    @Column(name = "created", nullable = false, updatable = false)
    private Date created;

    @UpdateTimestamp
    @Column(nullable = false, updatable = true)
    private Date lastUpdated;

    public Promotion(Long promotionId, String promotionName, String promotionDescription, String promoCode, Date created, Date lastUpdated) {
        this.promotionId = promotionId;
        this.promotionName = promotionName;
        this.promotionDescription = promotionDescription;
        this.promoCode = promoCode;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public Promotion() {

    }

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getPromotionDescription() {
        return promotionDescription;
    }

    public void setPromotionDescription(String promotionDescription) {
        this.promotionDescription = promotionDescription;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getInsertedBy() {
        return insertedBy;
    }

    public void setInsertedBy(String insertedBy) {
        this.insertedBy = insertedBy;
    }
}
