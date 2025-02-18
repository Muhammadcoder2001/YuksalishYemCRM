package com.BedanaYuksalish.BedanaYemlari.Service;

import com.BedanaYuksalish.BedanaYemlari.Entity.Product;
import com.BedanaYuksalish.BedanaYemlari.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product getProduct(Long id) {
        return repository.findById(id).get();
    }

    public Product saveProduct(Product product) {
        product.setDate(new Date(System.currentTimeMillis()));
        return repository.save(product);
    }

    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
