package com.loja.online.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.online.model.Product;
import com.loja.online.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Product>> list() {
		List<Product> products = (List<Product>) repository.findAll();
		return ResponseEntity.
				ok().
				body(products);
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> add(@RequestBody Product prod) {
		
		try {
			repository.save(prod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok("Produto adicionado com sucesso!");
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<Product> edit(@Valid @RequestBody Product prod) {
		
        if (!repository.findById(prod.getId()).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(repository.save(prod));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok("Produto removido com sucesso!");
	}
	
	@GetMapping(path = "/search-product/{search}")
	public ResponseEntity<List<Product>> search(@PathVariable String search) {

		List<Product> prods = new ArrayList<>();
		prods = repository.findByName(search);

		return ResponseEntity.ok(prods);
		
	}
	
}