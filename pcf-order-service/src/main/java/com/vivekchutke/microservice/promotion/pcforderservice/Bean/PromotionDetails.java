package com.vivekchutke.microservice.promotion.pcforderservice.Bean;

public class PromotionDetails {

    private Long promotionId;

    private String promotionName;

    private String promotionDescription;

    public PromotionDetails(Long promotionId, String promotionName, String promotionDescription) {
        this.promotionId = promotionId;
        this.promotionName = promotionName;
        this.promotionDescription = promotionDescription;
    }

    public PromotionDetails() {

    }

    @Override
    public String toString() {
        return "PromotionDetails{" +
                "promotionId=" + promotionId +
                ", promotionName='" + promotionName + '\'' +
                ", promotionDescription='" + promotionDescription + '\'' +
                '}';
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
}
