package com.example.practice3jpa.service;

import com.example.practice3jpa.entities.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ProductServiceImpl implements ProductService {
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    @Override
    public List<Product> findAll() {
        return em.createNamedQuery(Product.FIND_ALL, Product.class).getResultList();
    }

    @Transactional(readOnly=true)
    @Override
    public Product findProductById(Long id) {
        TypedQuery<Product> query = em.createNamedQuery(Product.FIND_PRODUCT_BY_ID, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();

//        public Person show(int id) {
//            return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
//        }


    }

    @Transactional(readOnly=true)
    @Override
    public List<Product> findAllWithClient() {
        List<Product> products = em.createNamedQuery(Product.FIND_ALL_WITH_CLIENT, Product.class).getResultList();
        return products;
    }

    @Override
    public void delete(Product product) {
        Product productToBeDeleted = em.merge(product);
        em.remove(productToBeDeleted);
    }
}


