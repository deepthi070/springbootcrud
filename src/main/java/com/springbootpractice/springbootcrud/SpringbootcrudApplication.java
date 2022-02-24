package com.springbootpractice.springbootcrud;

import com.springbootpractice.springbootcrud.entity.ProductEntity;
import com.springbootpractice.springbootcrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringbootcrudApplication implements CommandLineRunner {

	@Autowired
	ProductRepository productRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcrudApplication.class, args);
	}


	public void run(String[] args) throws Exception{
		productRepo.save(new ProductEntity(5,"Lenovo",500));
		productRepo.save(new ProductEntity(6,"MI",800));
		productRepo.save(new ProductEntity(7,"samsung",900));
		productRepo.save(new ProductEntity(8,"Iphone",1000));

		Iterable<ProductEntity> it = productRepo.findAll();

		System.out.println("ALL PRODUCTS:");
		it.forEach(item -> System.out.println(item));

		List<ProductEntity> items = productRepo.findByItem("MI");
		System.out.println("ITEM:");
		items.forEach(item1-> System.out.println(item1));

		List<ProductEntity> itemCost = productRepo.getProductByPrice(600);
		System.out.println("PRICE OF PRODUCT:");
		itemCost.forEach(item2-> System.out.println(item2));



	}



}
