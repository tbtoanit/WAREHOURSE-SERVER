package com.toandev.khohang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/prod")
public class ProdController {
	
	@Autowired
	private ProdService prodService;
	

	@GetMapping("/getAllProd")
	public List<Product> getAllProd(){
		System.out.println(prodService.getAllProd());
		return prodService.getAllProd();
	}

	@PostMapping("/saveProd")
	public ResponseEntity<String> saveProd(@RequestBody Product product) {
	    try {
	        prodService.saveProduct(product);
	        return ResponseEntity.ok("Product saved successfully!");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save product.");
	    }
	}

	@PostMapping("/delProd")
	public ResponseEntity<String> delProd (@RequestBody Product product) {
		try {
			prodService.deleteProduct(product.getProd_id());
			return ResponseEntity.ok ("Product delete successfully");
		}catch (Exception e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete product.");
		}
	}
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
	@PostMapping("/searchProds")
	public ResponseEntity<List<Product>> searchProducts(@RequestParam String prod_name) {
		try {
			List<Product> products = prodService.searchProducts(prod_name);
			return ResponseEntity.ok(products);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PostMapping("/searchProdsId")
	public ResponseEntity<List<Product>> searchProductsId(@RequestParam String prod_id) {
		try {
			List<Product> products = prodService.searchProductId(prod_id);
			return ResponseEntity.ok(products);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	@PutMapping("/editProdId/{prod_id}")
	public ResponseEntity<?> updateProduct(@PathVariable String prod_id, @RequestBody Product product) {
		try {
			prodService.updateProductInformation(prod_id, product);
			return ResponseEntity.ok().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
