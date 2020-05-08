package hu.uszeged.stud.gmbalint.webshop.repository;

import hu.uszeged.stud.gmbalint.webshop.entity.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Long> {
}
