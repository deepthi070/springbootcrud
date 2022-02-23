package com.springbootpractice.springbootcrud.controller;

import com.springbootpractice.springbootcrud.service.ProductService;
import com.springbootpractice.springbootcrud.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<ProductEntity> listALL(){
        return service.listAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductEntity> getById(@PathVariable Integer id){
        try{
            ProductEntity product = service.getById(id);
            return new ResponseEntity<ProductEntity>(product, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<ProductEntity>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public void add(@RequestBody ProductEntity product){
        service.add(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductEntity> update(@RequestBody ProductEntity product,@PathVariable Integer id){
        try{
            ProductEntity prod = service.getById(id);
            service.add(product);
            return new ResponseEntity<ProductEntity>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<ProductEntity>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

}
