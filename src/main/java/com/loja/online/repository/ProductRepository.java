package com.loja.online.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.loja.online.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
	@Query("SELECT p FROM Product p WHERE p.title LIKE %?1%") 
	List<Product> findByName(String search);
}
