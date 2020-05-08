package hu.uszeged.stud.gmbalint.webshop.service.impl;

import hu.uszeged.stud.gmbalint.webshop.entity.Product;
import hu.uszeged.stud.gmbalint.webshop.repository.ProductRepository;
import hu.uszeged.stud.gmbalint.webshop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Optional<Product> getProduct(long id) {
        return productRepository.findById(id);
    }
}
