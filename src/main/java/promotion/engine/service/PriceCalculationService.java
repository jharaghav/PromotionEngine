package promotion.engine.service;

import promotion.engine.model.Order;

public interface PriceCalculationService {

    public int getTotalPrice(Order order);

    public int getPriceForCategoryA(int quantityA);

    public int getPriceForCategoryB(int quantityB);

    public int getPriceForCategoryCAndD(int quantityC, int quantityD);
}
