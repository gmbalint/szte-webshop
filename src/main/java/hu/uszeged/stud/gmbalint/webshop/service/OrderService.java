package hu.uszeged.stud.gmbalint.webshop.service;

import hu.uszeged.stud.gmbalint.webshop.entity.Order;
import hu.uszeged.stud.gmbalint.webshop.entity.Product;
import hu.uszeged.stud.gmbalint.webshop.entity.User;

import java.util.List;
import java.util.Map;


public interface OrderService {
    void placeOrder(User user, Map<Product, Integer> products);
    List<Order> listOrders(User user);
}
