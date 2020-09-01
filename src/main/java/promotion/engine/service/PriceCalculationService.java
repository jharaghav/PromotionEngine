package promotion.engine.service;

public interface PriceCalculationService {

    public int getPriceForCategoryA(int quantityA);

    public int getPriceForCategoryB(int quantityB);

    public int getPriceForCategoryCAndD(int quantityC,int quantityD);
}
