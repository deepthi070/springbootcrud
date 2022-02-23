package com.springbootpractice.springbootcrud.service;

import com.springbootpractice.springbootcrud.repository.ProductRepository;
import com.springbootpractice.springbootcrud.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository prodRepo;

    public List<ProductEntity> listAll(){
        return prodRepo.findAll();
    }

    public ProductEntity getById(Integer id){
        return prodRepo.findById(id).get();
    }

    public void add(ProductEntity product){
        prodRepo.save(product);
    }

    public void delete(Integer id){
        prodRepo.deleteById(id);
    }

}
