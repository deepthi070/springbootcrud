package com.springbootpractice.springbootcrud.repository;

import com.springbootpractice.springbootcrud.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {

}
