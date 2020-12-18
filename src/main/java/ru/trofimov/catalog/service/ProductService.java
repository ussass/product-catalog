package ru.trofimov.catalog.service;

import ru.trofimov.catalog.model.Product;

import java.util.List;

public interface ProductService {
    Product findById(int id);

    void save(Product product);

    void update(Product product);

    void delete(Product product);

    List<Product> findAll();

    List<Product> search(String search);
}
