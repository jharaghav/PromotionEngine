package promotion.engine.service.impl;

import org.springframework.stereotype.Service;
import promotion.engine.model.Order;
import promotion.engine.service.PriceCalculationService;
import promotion.engine.utilities.CategoryPriceConstants;
import promotion.engine.utilities.ProductPromotionPriceRules;

import java.util.Map;

@Service
public class PriceCalculationServiceImpl implements PriceCalculationService {

    @Override
    public int getTotalPrice(Order order) {
        int totalPrice = 0;
        int quantityC = 0;
        int quantityD = 0;
        Map<CategoryPriceConstants, Integer> categoryQuantities = order.getCategoryQuantities();
        for (Map.Entry<CategoryPriceConstants, Integer> entry : categoryQuantities.entrySet()) {
            if (entry.getKey().equals(CategoryPriceConstants.A)) {
                totalPrice += getPriceForCategoryA(entry.getValue());
            } else if (entry.getKey().equals(CategoryPriceConstants.B)) {
                totalPrice += getPriceForCategoryB(entry.getValue());
            } else if (entry.getKey().equals(CategoryPriceConstants.C)) {
                quantityC = entry.getValue();
            } else if (entry.getKey().equals(CategoryPriceConstants.D)) {
                quantityD = entry.getValue();
            }
        }
        totalPrice += getPriceForCategoryCAndD(quantityC, quantityD);
        return totalPrice;
    }

    @Override
    public int getPriceForCategoryA(int quantityA) {
        int categoryPriceforA = CategoryPriceConstants.A.categoryPrices;
        int promotionPriceforA = ProductPromotionPriceRules.THREE_A.promotionPrices;
        return getTotalPrice(quantityA, categoryPriceforA, promotionPriceforA, 3);
    }

    @Override
    public int getPriceForCategoryB(int quantityB) {
        int categoryPriceforB = CategoryPriceConstants.B.categoryPrices;
        int promotionPriceforB = ProductPromotionPriceRules.TWO_B.promotionPrices;
        return getTotalPrice(quantityB, categoryPriceforB, promotionPriceforB, 2);
    }

    @Override
    public int getPriceForCategoryCAndD(int quantityC, int quantityD) {
        int categoryPriceforC = CategoryPriceConstants.C.categoryPrices;
        int categoryPriceforD = CategoryPriceConstants.D.categoryPrices;
        int promotionPriceforCandD = ProductPromotionPriceRules.C_AND_D.promotionPrices;
        int quantityWithoutDiscountforC = 0;
        int quantityWithDiscountforC = 0;
        int quantityWithoutDiscountforD = 0;
        int quantityWithDiscountforD = 0;
        int totalPrice = 0;
        if (quantityC < quantityD) {
            quantityWithDiscountforC = quantityC;
            quantityWithoutDiscountforD = quantityD - quantityC;
            totalPrice = (quantityWithDiscountforC * promotionPriceforCandD) + (quantityWithoutDiscountforD * categoryPriceforD);
        } else if (quantityD < quantityC) {
            quantityWithDiscountforD = quantityD;
            quantityWithoutDiscountforC = quantityC - quantityD;
            totalPrice = (quantityWithDiscountforD * promotionPriceforCandD) + (quantityWithoutDiscountforC * categoryPriceforC);
        } else {
            return promotionPriceforCandD * quantityD;
        }
        return totalPrice;
    }

    private int getTotalPrice(int quantity, int categoryPrice, int promotionPrice, int offerQuantity) {
        int rem = quantity % offerQuantity;
        int quantityWithoutDiscount = 0;
        int quantityWithDiscount = 0;
        if (rem != 0) {
            quantityWithoutDiscount = rem;
        }
        if (quantity >= offerQuantity) {
            quantityWithDiscount = quantity / offerQuantity;
        }
        return (quantityWithDiscount * promotionPrice) + (quantityWithoutDiscount * categoryPrice);
    }
}
