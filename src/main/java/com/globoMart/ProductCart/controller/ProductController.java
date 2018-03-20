package com.globoMart.ProductCart.controller;

import com.globoMart.ProductCart.Bean.Product;
import com.globoMart.ProductCart.DAO.ProductDao;
import com.globoMart.ProductCart.Entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    Product product;
    @Autowired
    ProductDao productDao;

    @GetMapping(value = "/add/{id}",produces = {"application/json"})
    public List<Product> getProducts(@PathVariable String id){
        List<Product> productList = new ArrayList<>();
        List<ProductEntity> productEntityList = new ArrayList<>();
        productEntityList=productDao.getProducts(id);
        for (ProductEntity productEntity:productEntityList) {
            Product prd = new Product();
            prd.setProductDesc(productEntity.getProductDesc());
            prd.setProductName(productEntity.getProductName());
            prd.setProductPrice(productEntity.getProductPrice());
            productList.add(prd);
        }
        return productList;
    }

    @PostMapping(value = "/product/add",produces = {"application/json"})
    public void addProducts(@RequestBody Product product, BindingResult bindingResul){
        productDao.addProducts(product);
    }

    @DeleteMapping(value = "/product/delete",produces = {"application/json"})
    public void deleteProduct(@RequestBody Product product){
        productDao.deleteProduct(product);
    }
}
