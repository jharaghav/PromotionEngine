package promotion.engine.utilities;

public enum ProductPromotionPrice {
    THREE_A(130),
    TWO_B(45),
    C_AND_D(30);

    public final int promotionPrices;

    private ProductPromotionPrice(int promotionPrices) {
        this.promotionPrices = promotionPrices;
    }
}
