package promotion.engine.service.impl;

import org.springframework.stereotype.Service;
import promotion.engine.service.PriceCalculationService;
import promotion.engine.utilities.CategoryPriceConstants;
import promotion.engine.utilities.ProductPromotionPrice;

@Service
public class PriceCalculationServiceImpl implements PriceCalculationService {

    @Override
    public int getPriceForCategoryA(int quantityA) {
        int categoryPriceforA = CategoryPriceConstants.A.categoryPrices;
        int promotionPriceforA = ProductPromotionPrice.THREE_A.promotionPrices;
        int rem = quantityA % 3;
        int quantityWithoutDiscount = 0;
        int quantityWithDiscount = 0;
        if (rem != 0) {
            quantityWithoutDiscount = rem;
        } else {
            quantityWithDiscount = quantityA / 3;
        }
        return (quantityWithDiscount * promotionPriceforA) + (quantityWithoutDiscount * categoryPriceforA);
    }

    @Override
    public int getPriceForCategoryB(int quantityB) {
        int categoryPriceforB = CategoryPriceConstants.B.categoryPrices;
        int promotionPriceforB = ProductPromotionPrice.TWO_B.promotionPrices;
        int rem = quantityB % 2;
        int quantityWithoutDiscount = 0;
        int quantityWithDiscount = 0;
        if (rem != 0) {
            quantityWithoutDiscount = rem;
        } else {
            quantityWithDiscount = quantityB / 3;
        }
        return (quantityWithDiscount * promotionPriceforB) + (quantityWithoutDiscount * categoryPriceforB);

    }

    @Override
    public int getPriceForCategoryCAndD(int quantityC, int quantityD) {
        int categoryPriceforC = CategoryPriceConstants.C.categoryPrices;
        int categoryPriceforD = CategoryPriceConstants.D.categoryPrices;
        int promotionPriceforCandD = ProductPromotionPrice.C_AND_D.promotionPrices;
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
}
