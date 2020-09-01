package promotion.engine.utilities;

public enum ProductPromotionPriceRules {
    THREE_A(130),
    TWO_B(45),
    C_AND_D(30);

    public final int promotionPrices;

    private ProductPromotionPriceRules(int promotionPrices) {
        this.promotionPrices = promotionPrices;
    }
}
