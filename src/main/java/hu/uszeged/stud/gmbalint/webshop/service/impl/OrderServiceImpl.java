package hu.uszeged.stud.gmbalint.webshop.service.impl;

import hu.uszeged.stud.gmbalint.webshop.converter.OrderItemConverter;
import hu.uszeged.stud.gmbalint.webshop.domain.OrderStatus;
import hu.uszeged.stud.gmbalint.webshop.entity.Order;
import hu.uszeged.stud.gmbalint.webshop.entity.Product;
import hu.uszeged.stud.gmbalint.webshop.entity.User;
import hu.uszeged.stud.gmbalint.webshop.repository.OrderRepository;
import hu.uszeged.stud.gmbalint.webshop.repository.ProductRepository;
import hu.uszeged.stud.gmbalint.webshop.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderItemConverter orderItemConverter;

    public OrderServiceImpl(final ProductRepository productRepository,
                            final OrderRepository orderRepository,
                            final OrderItemConverter orderItemConverter) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.orderItemConverter = orderItemConverter;
    }

    @Override
    public void placeOrder(User user, Map<Product, Integer> products) {
        final Order order = Order.builder()
                .user(user)
                .items(orderItemConverter.convert(products))
                .orderTime(Instant.now())
                .status(OrderStatus.Waiting)
                .build();

        orderRepository.save(order);

        products.forEach((product, quantity) -> {
            product.setQuantity(product.getQuantity() - quantity);
            productRepository.save(product);
        });

        System.out.println("Order placed successfully.");
    }

    @Override
    public List<Order> listOrders(User user) {
        return orderRepository.findAllByUser(user);
    }
}
