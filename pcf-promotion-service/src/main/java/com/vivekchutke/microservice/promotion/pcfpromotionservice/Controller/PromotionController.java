package com.vivekchutke.microservice.promotion.pcfpromotionservice.Controller;

import com.vivekchutke.microservice.promotion.pcfpromotionservice.Entity.Promotion;
import com.vivekchutke.microservice.promotion.pcfpromotionservice.Exception.PromotionNotFoundException;
import com.vivekchutke.microservice.promotion.pcfpromotionservice.Repository.PromotionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
