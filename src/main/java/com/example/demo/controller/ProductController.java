package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.product;
import com.example.demo.service.ProductService;
import java.util.List;

import javax.websocket.server.PathParam;
@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	 @PostMapping("/addProduct")
	    public product addProduct(@RequestBody product prod) {
	        return service.saveProduct(prod);
	    }

	    @PostMapping("/addProducts")
	    public List<product> addProducts(@RequestBody List<product> products) {
	        return service.saveProducts(products);
	    }

	    @GetMapping("/products")
	    public List<product> findAllProducts() {
	        return service.getProducts();
	    }

	    @GetMapping("/productById")
	    public product findProductById(@RequestParam int id) {
	        return service.getProductById(id);
	    }
//	    
//	    @GetMapping("/productById")
//	    public ResponseEntity<product> findProductById(@RequestParam int id) {
//	        product prod=service.getProductById(id);
//	        return new ResponseEntity<product>(prod,HttpStatus.OK);
//	    }


	    @GetMapping("/product/{name}")
	    public product findProductByName(@PathVariable String name) {
	        return service.getProductByName(name);
	    }

	    @PutMapping("/update")
	    public product updateProduct(@RequestBody product prod) {
	        return service.updateProduct(prod);
	    }

	    @DeleteMapping("/delete/{id}")
	    public String deleteProduct(@PathVariable int id) {
	        return service.deleteProduct(id);
	    }
}
