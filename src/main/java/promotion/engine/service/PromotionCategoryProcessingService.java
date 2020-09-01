package promotion.engine.service;

import org.springframework.stereotype.Service;
import promotion.engine.model.Order;

@Service
public interface PromotionCategoryProcessingService {

    public Order getProductPromotions();
}
