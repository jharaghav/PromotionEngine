package promotion.engine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import promotion.engine.model.Order;
import promotion.engine.service.PromotionCategoryProcessingService;
import promotion.engine.utilities.CategoryPriceConstants;

import java.util.HashMap;
import java.util.Map;

@Service
public class PromotionCategoryProcessingServiceImpl implements PromotionCategoryProcessingService {

    @Autowired
    private Order order;


    @Override
    public Order getProductPromotions() {
        Map<CategoryPriceConstants, Integer> categoryQuantities = new HashMap<>();
        categoryQuantities.put(CategoryPriceConstants.A, 1);
        categoryQuantities.put(CategoryPriceConstants.B, 1);
        categoryQuantities.put(CategoryPriceConstants.C, 1);
//        categoryQuantities.put(CategoryPriceConstants.D, 1);
        order.setCategoryQuantities(categoryQuantities);
        return order;
    }

}
