package promotion.engine.model;

import lombok.Data;
import org.springframework.stereotype.Component;
import promotion.engine.utilities.CategoryPriceConstants;

import java.util.HashMap;
import java.util.Map;

@Data
@Component
public class Order {

    Map<CategoryPriceConstants, Integer> categoryQuantities = new HashMap<>();

}
