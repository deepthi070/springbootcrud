package com.springbootpractice.springbootcrud.repository;

import com.springbootpractice.springbootcrud.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {

    public List<ProductEntity> findByItem(String item);

    @Query(value = "select * from product p where p.price >:price",nativeQuery = true)
    public List<ProductEntity> getProductByPrice(@Param("price") float price);

}
