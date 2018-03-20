package com.globoMart.ProductCart.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Entity
@Table(name = "PRODUCT_DETAILS")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "PRD_ID")
    private int productID;

    @CreationTimestamp
    @Column(name = "CRT_DTTM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "PRD_NME", nullable = false,length = 2)
    private String productName;

    @Column(name = "PRD_DESC",nullable = false,length = 3)
    private String productDesc;

    @Column(name = "PRD_PRICE")
    private float productPrice;

    @UpdateTimestamp
    @Column(name = "UPATE_DTTM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Column(name = "USER_ID")
    private String userId;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
}
