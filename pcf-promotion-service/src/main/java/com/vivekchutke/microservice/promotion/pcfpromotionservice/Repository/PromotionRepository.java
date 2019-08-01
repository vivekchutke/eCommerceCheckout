package com.vivekchutke.microservice.promotion.pcfpromotionservice.Repository;

import com.vivekchutke.microservice.promotion.pcfpromotionservice.Entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

public interface PromotionRepository  extends JpaRepository<Promotion, Long> {

    public Promotion findByPromotionId(@PathVariable Long promoId);
}
