package gp.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gp.productservice.model.Product;
import gp.productservice.repo.ProductRepoistory;

@Service
public class ProductService {

	@Autowired
	private ProductRepoistory productRepo;
	
	
	// Post methods
	
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products) {
		return productRepo.saveAll(products);
	}
	
	// all get methods
	
	public List<Product> getProducts() {
		return productRepo.findAll();
	}
	
	public Product getProductById(Long id) {
		return productRepo.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name) {
		return productRepo.getByName(name);
	}
	
	
	// update method
	
	public Product updateProduct(Product product) {
		Product existingProduct = productRepo.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		
		return productRepo.save(product);
	}
	
	// delete method
	
	public String deleteProduct(Long id) {
		productRepo.deleteById(id);
		return "Product removed >> "+id;
	}
}
