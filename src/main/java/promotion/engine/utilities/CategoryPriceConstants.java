package promotion.engine.utilities;

public enum CategoryPriceConstants {
    A(50),
    B(30),
    C(20),
    D(15);

    public final int categoryPrices;

    private CategoryPriceConstants(int categoryPrices) {
        this.categoryPrices = categoryPrices;
    }
}
