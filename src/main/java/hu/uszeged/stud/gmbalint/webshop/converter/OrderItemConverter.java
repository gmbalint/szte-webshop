package hu.uszeged.stud.gmbalint.webshop.converter;

import hu.uszeged.stud.gmbalint.webshop.entity.OrderItem;
import hu.uszeged.stud.gmbalint.webshop.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class OrderItemConverter {
    public List<OrderItem> convert(Map<Product, Integer> products) {
        final List<OrderItem> items = new ArrayList<>();
        products.forEach((product, quantity) -> {
            final OrderItem item = OrderItem.builder()
                    .product(product)
                    .quantity(quantity)
                    .price(product.getPrice())
                    .build();

            items.add(item);
        });

        return items;
    }
}
