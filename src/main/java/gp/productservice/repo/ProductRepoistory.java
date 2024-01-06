package gp.productservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import gp.productservice.model.Product;

public interface ProductRepoistory extends JpaRepository<Product, Long>{

	Product getByName(String name);

}
