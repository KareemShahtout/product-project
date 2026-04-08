package com.company.products.dao;

import com.company.products.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class ProductDaoHibernateImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @PostConstruct
    public void validateConfig() {
        if (sessionFactory == null) {
            throw new RuntimeException("SessionFactory not injected");
        }
    }

    @Override
    public Product save(Product product) {
        sessionFactory.getCurrentSession().persist(product);
        return product;
    }

    @Override
    public boolean deleteById(int id) {
//        sessionFactory.getCurrentSession().createQuery("delete from ProductDetails where product_id = :id")
//                .setParameter("id", id)
//                .executeUpdate();
//
//        sessionFactory.getCurrentSession().createQuery("delete from Product where id = :id")
//                .setParameter("id", id)
//                .executeUpdate();

        Product product = findById(id);
        if (product != null) {
            sessionFactory.getCurrentSession().delete(product);
            return true;
        }
        return false;

    }

    @Override
    public Product update(Product product) {
        return (Product) sessionFactory.getCurrentSession().merge(product);
//      Session session = sessionFactory.getCurrentSession();
//      session.update(product);
    }

    @Override
    public Product findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product", Product.class).list();
    }

}
