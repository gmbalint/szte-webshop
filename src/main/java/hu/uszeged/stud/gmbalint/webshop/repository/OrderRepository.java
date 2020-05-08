package hu.uszeged.stud.gmbalint.webshop.repository;

import hu.uszeged.stud.gmbalint.webshop.entity.Order;
import hu.uszeged.stud.gmbalint.webshop.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findAllByUser(User user);
}
