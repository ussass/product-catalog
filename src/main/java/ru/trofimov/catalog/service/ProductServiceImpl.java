package ru.trofimov.catalog.service;

import ru.trofimov.catalog.dao.ProductDao;
import ru.trofimov.catalog.dao.ProductDaoImpl;
import ru.trofimov.catalog.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductDao dao = new ProductDaoImpl();
    @Override
    public Product findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void save(Product product) {
        dao.save(product);
    }

    @Override
    public void update(Product product) {
        dao.update(product);
    }

    @Override
    public void delete(Product product) {
        dao.delete(product);
    }

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Product> search(String search) {
        List<Product> products = dao.findAll();
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(search))
                result.add(product);
        }
        return result;
    }
}
