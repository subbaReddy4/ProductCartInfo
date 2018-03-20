package com.globoMart.ProductCart.DAO;

import com.globoMart.ProductCart.Bean.Product;
import com.globoMart.ProductCart.Entity.ProductEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
@Repository@Transactional
public class ProductDao {
    @Autowired
    EntityManagerFactory entityManagerFactory;
    @Autowired ProductEntity productEntity;

    public List<ProductEntity> getProducts(String value){
        Session currentSession = entityManagerFactory.unwrap(SessionFactory.class).openSession();
        TypedQuery<ProductEntity> query = currentSession.createQuery(
                "SELECT c FROM ProductEntity c WHERE c.productName =:prdId OR c.productDesc =:prdDesc",
                ProductEntity.class);
        return query.setParameter("prdId",value).setParameter("prdDesc",value).getResultList();
    }

    public void addProducts(Product product){
        Session currentSession = entityManagerFactory.unwrap(SessionFactory.class).openSession();
        TypedQuery<ProductEntity> query = currentSession.createQuery(
                "SELECT c FROM ProductEntity c WHERE c.productName =:prdId OR c.productDesc =:prdDesc",
                ProductEntity.class);
         List<ProductEntity>productEntityList=query.setParameter("prdId",product.getProductName()).setParameter("prdDesc",product.getProductDesc()).getResultList();
        if(productEntityList.isEmpty()) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            productEntity.setProductName(product.getProductName());
            productEntity.setProductDesc(product.getProductDesc());
            productEntity.setProductPrice(product.getProductPrice());
            productEntity.setCreatedDate(timestamp);
            productEntity.setUpdateDate(timestamp);
            productEntity.setUserId("SYSTEM");
            currentSession.save("ProductEntity.Class", productEntity);
        }else{
            productEntity=productEntityList.get(0);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            productEntity.setProductPrice(product.getProductPrice());
            productEntity.setUpdateDate(timestamp);
            currentSession.update(productEntity);
        }

    }

    public void deleteProduct(Product product){
        Session currentSession = entityManagerFactory.unwrap(SessionFactory.class).openSession();
        TypedQuery<ProductEntity> query = currentSession.createQuery(
                "SELECT c FROM ProductEntity c WHERE c.productName =:prdId OR c.productDesc =:prdDesc",
                ProductEntity.class);
        List<ProductEntity>productEntityList=query.setParameter("prdId",product.getProductName()).setParameter("prdDesc",product.getProductDesc()).getResultList();
        if(productEntityList.isEmpty()) {
            System.out.println("No Product Available for Matching");
        }else{
           productEntity= productEntityList.get(0);
           currentSession.delete(productEntity.getProductID());
        }

    }
}
