package promotion.engine;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import promotion.engine.model.Order;
import promotion.engine.service.PriceCalculationService;
import promotion.engine.service.PromotionCategoryProcessingService;
import promotion.engine.service.impl.PriceCalculationServiceImpl;
import promotion.engine.service.impl.PromotionCategoryProcessingServiceImpl;


@SpringBootApplication
@Slf4j
public class EngineApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(EngineApplication.class, args);
        PromotionCategoryProcessingService promotionCategoryProcessingService = applicationContext.getBean(PromotionCategoryProcessingServiceImpl.class);
        Order order = promotionCategoryProcessingService.getProductPromotions();
        PriceCalculationService priceCalculationService = applicationContext.getBean(PriceCalculationServiceImpl.class);
        int totalPrice = priceCalculationService.getTotalPrice(order);
        log.info("Total Price : {}", totalPrice);
    }
}
