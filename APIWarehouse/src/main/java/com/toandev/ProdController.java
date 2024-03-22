package com.toandev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prod")
public class ProdController {
	
	@Autowired
	private ProdService prodService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getAllProd")
	public List<Product> getAllProd(){
		System.out.println(prodService.getAllProd());
		return prodService.getAllProd();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/saveProd")
	public ResponseEntity<String> saveProd(@RequestBody Product product) {
	    try {
	        prodService.saveProduct(product);
	        return ResponseEntity.ok("Product saved successfully!");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save product.");
	    }
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/delProd")
	public ResponseEntity<String> delProd (@RequestBody Product product) {
		try {
			prodService.deleteProduct(product.getProd_id());
			return ResponseEntity.ok ("Product delete successfully");
		}catch (Exception e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete product.");
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/delProds")
	public ResponseEntity<String> delProds (@RequestBody List<Product> products) {
		try {
			for(Product p:products){
				prodService.deleteProduct(p.getProd_id());
			}
			return ResponseEntity.ok ("Product delete successfully");
		}catch (Exception e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete product.");
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/searchProds")
	public ResponseEntity<List<Product>> searchProducts(@RequestParam String prod_name) {
	    try {
	        List<Product> products = prodService.searchProducts(prod_name);
	        return ResponseEntity.ok(products);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
	}
}
