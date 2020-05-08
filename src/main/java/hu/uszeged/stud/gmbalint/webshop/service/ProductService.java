package hu.uszeged.stud.gmbalint.webshop.service;

import hu.uszeged.stud.gmbalint.webshop.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProduct(long id);
}
