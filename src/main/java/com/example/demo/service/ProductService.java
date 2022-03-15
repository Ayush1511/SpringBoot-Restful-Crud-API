package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.product;
import com.example.demo.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public product saveProduct(product prod) {
		return repository.save(prod);
	}
	  public List<product> saveProducts(List<product> products) {
	        return repository.saveAll(products);
	    }

	    public List<product> getProducts() {
	        return repository.findAll();
	    }

	    public product getProductById(int id) {
	        return repository.findById(id).orElse(null);
	    }

	    public product getProductByName(String name) {
	        return repository.findByName(name);
	    }

	    public String deleteProduct(int id) {
	        repository.deleteById(id);
	        return "product removed !! " + id;
	    }
	    
	    public product updateProduct(product prod) {
	        product existingProduct = repository.findById(prod.getId()).orElse(null);
	        existingProduct.setName(prod.getName());
	        existingProduct.setQuantity(prod.getQuantity());
	        existingProduct.setPrice(prod.getPrice());
	        return repository.save(existingProduct);
	    }
	

}
