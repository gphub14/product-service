package gp.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gp.productservice.model.Product;
import gp.productservice.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/product/create")
	private Product createProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@PostMapping("/products/create")
	private List<Product> createProducts(@RequestBody List<Product> product) {
		return productService.saveProducts(product);
	}
	
	@GetMapping("/products")
	private List<Product> findAllProducts() {
		return productService.getProducts();
	}
	
	@GetMapping("/product/id/{id}")
	private Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/product/name/{name}")
	private Product getProductByName(@PathVariable String name) {
		return productService.getProductByName(name);
	}
	
	@PutMapping("/product/update")
	private Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/product/delete/{id}")
	private String deleteProduct(@PathVariable Long id) {
		return productService.deleteProduct(id);
	}
}
