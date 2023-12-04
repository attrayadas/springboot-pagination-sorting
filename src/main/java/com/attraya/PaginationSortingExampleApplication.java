package com.attraya;

import com.attraya.dto.APIResponse;
import com.attraya.entity.Product;
import com.attraya.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/products")
public class PaginationSortingExampleApplication {

	@Autowired
	private ProductService service;

	@GetMapping
	private APIResponse<List<Product>> getProducts(){
		List<Product> allProducts = service.findAllProducts();
		return new APIResponse<>(allProducts.size(), allProducts);
	}

	public static void main(String[] args) {
		SpringApplication.run(PaginationSortingExampleApplication.class, args);
	}

}
