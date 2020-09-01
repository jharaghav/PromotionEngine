package promotion.engine.service;

import org.springframework.stereotype.Service;
import promotion.engine.model.Order;

@Service
public interface PriceCalculationService {

    public int getTotalPrice(Order order);

    public int getPriceForCategoryA(int quantityA);

    public int getPriceForCategoryB(int quantityB);

    public int getPriceForCategoryCAndD(int quantityC, int quantityD);
}
