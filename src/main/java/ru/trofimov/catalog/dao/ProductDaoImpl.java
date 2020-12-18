package ru.trofimov.catalog.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.trofimov.catalog.config.HibernateSessionFactoryUtil;
import ru.trofimov.catalog.model.Product;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public Product findById(int id) {
        Product product;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            product = session.get(Product.class, id);
        }
        return product;
    }

    @Override
    public void save(Product product) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }
    }

    @Override
    public void update(Product product) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
        }
    }

    @Override
    public void delete(Product product) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(product);
            transaction.commit();
        }
    }

    @Override
    public List<Product> findAll() {
        String sql = "FROM Product ORDER BY id desc";
        return (List<Product>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery(sql).list();
    }
}
