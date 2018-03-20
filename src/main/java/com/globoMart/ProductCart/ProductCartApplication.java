package com.globoMart.ProductCart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProductCartApplication {

	public static void main(String[] args) {
		System.out.println("Started the Server");
		SpringApplication.run(ProductCartApplication.class, args);
		System.out.println("Running Successfully");
}
}