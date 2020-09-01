package promotion.engine;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import promotion.engine.model.Order;
import promotion.engine.service.PriceCalculationService;
import promotion.engine.utilities.CategoryPriceConstants;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class EngineApplicationTests {

	@Autowired
	private PriceCalculationService priceCalculationService;

	@Test
	void contextLoads() {
	}

	@Test
	public void getTotalCostTest() {
		int actual = priceCalculationService.getTotalPrice(getOrder());
		Assert.assertSame(100,actual);
	}

	private Order getOrder() {
		Order order = new Order();
		Map<CategoryPriceConstants, Integer> categoryQuantities = new HashMap<>();
		categoryQuantities.put(CategoryPriceConstants.A, 1);
		categoryQuantities.put(CategoryPriceConstants.B, 1);
		categoryQuantities.put(CategoryPriceConstants.C, 1);
//        categoryQuantities.put(CategoryPriceConstants.D, 1);
		order.setCategoryQuantities(categoryQuantities);
		return order;
	}

}
