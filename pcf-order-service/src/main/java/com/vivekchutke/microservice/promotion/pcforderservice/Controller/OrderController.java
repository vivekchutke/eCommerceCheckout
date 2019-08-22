package com.vivekchutke.microservice.promotion.pcforderservice.Controller;

import com.vivekchutke.microservice.promotion.pcforderservice.Bean.PromotionDetails;
import com.vivekchutke.microservice.promotion.pcforderservice.Exception.PromotionDetailsNotFoundException;
import com.vivekchutke.microservice.promotion.pcforderservice.Proxy.PromotionProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {

    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private PromotionProxy promotionProxy;

    @GetMapping("/order/promotion/{promoId}")
    public PromotionDetails getPromotionDetails(@PathVariable Long promoId) {
        PromotionDetails promotionDetails = promotionProxy.retrievePromotionDetails(promoId);
        if(promotionDetails == null) {
            throw new PromotionDetailsNotFoundException("Not able to get the promotion details:"+promoId);
        }

        promotionProxy.deletePromo(promoId);
        return promotionDetails;
    }

    @GetMapping("/order/promotion")
    public PromotionDetails getPromotionDetailsbyQueryParam(@RequestParam Long promoId) {
        logger.info("Getting promo details leagcy way: "+promoId);

        Map<String, Long> uriParameters = new HashMap<String, Long>();
        uriParameters.put("promoId",promoId);

        ResponseEntity<PromotionDetails> responseEntity = new RestTemplate().getForEntity("http://localhost:8005/promotion/{promoId}", PromotionDetails.class, uriParameters );

        PromotionDetails promotionDetails = responseEntity.getBody();

        if(promotionDetails == null) {
            throw new PromotionDetailsNotFoundException("Not able to get the promotion details:"+promoId);
        }
        return promotionDetails;
    }
}
