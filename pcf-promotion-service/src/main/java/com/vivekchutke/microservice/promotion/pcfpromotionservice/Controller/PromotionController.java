package com.vivekchutke.microservice.promotion.pcfpromotionservice.Controller;

import com.vivekchutke.microservice.promotion.pcfpromotionservice.Entity.Promotion;
import com.vivekchutke.microservice.promotion.pcfpromotionservice.Exception.PromotionNotFoundException;
import com.vivekchutke.microservice.promotion.pcfpromotionservice.Exception.PromotionRequestException;
import com.vivekchutke.microservice.promotion.pcfpromotionservice.Repository.PromotionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PromotionController {

    @Autowired
    private PromotionRepository promotionRepository;

    Logger logger = LoggerFactory.getLogger(PromotionRepository.class);

    @GetMapping("/promotion/{promoId}")
    public Promotion retrievePromotionByPromoId(@PathVariable Long promoId) {
        logger.info("Retrieving Promotion By Promo Id:"+promoId);

        Promotion promotion = promotionRepository.findByPromotionId(promoId);
        if(promotion == null) {
            throw new PromotionNotFoundException("Promotion with PromoId {PromoId}: not found:"+promoId );
        }
        return promotion;

    }

    @GetMapping("/promotions")
    public List<Promotion> retrieveAllPromotions() {
        logger.info("In Retrieve All product method: ");

        List<Promotion> promotions = promotionRepository.findAll();

        if(promotions.isEmpty()) {
            throw new PromotionNotFoundException("Promotion List is Empty");
        }
        return promotions;
    }

    @PostMapping("/promotion")
    public Promotion saveNewPromo(@RequestBody Promotion promotion, @RequestHeader String createdBy) {
        if(promotion == null) {
            throw new PromotionRequestException("Invalid promotion details passed");
        }
        promotion.setInsertedBy(createdBy);
        return promotionRepository.save(promotion);
    }

    @DeleteMapping("/promotion/{promoId}")
    public void deletePromotion(@PathVariable Long promoId) {

        promotionRepository.deleteById(promoId);

    }
}
