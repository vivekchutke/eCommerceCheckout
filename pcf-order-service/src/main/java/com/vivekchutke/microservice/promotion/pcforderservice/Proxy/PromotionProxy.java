package com.vivekchutke.microservice.promotion.pcforderservice.Proxy;

import com.vivekchutke.microservice.promotion.pcforderservice.Bean.PromotionDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Configuration
@FeignClient("pcf-promotion-service")
public interface PromotionProxy {

    @GetMapping("/promotion/{promoId}")
    public PromotionDetails retrievePromotionDetails(@PathVariable(name="promoId") Long promoId) ;

    @DeleteMapping("promotion/{promoId}")
    public void deletePromo(@PathVariable(name = "promoId") Long promoId);

}
