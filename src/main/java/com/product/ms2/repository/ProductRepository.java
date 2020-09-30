package com.product.ms2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.ms2.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
