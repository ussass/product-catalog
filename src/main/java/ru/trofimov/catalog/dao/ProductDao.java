package ru.trofimov.catalog.dao;

import ru.trofimov.catalog.model.Product;

import java.util.List;

public interface ProductDao {

    Product findById(int id);

    void save(Product product);

    void update(Product product);

    void delete(Product product);

    List<Product> findAll();
}
