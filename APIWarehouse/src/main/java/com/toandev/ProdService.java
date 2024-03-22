package com.toandev;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdService {
	@Autowired
	private ProdReponsitory prodReponsitory;
	
	public List<Product> getAllProd() {
        return prodReponsitory.findAll();
    }

    public Product getProdctById(String prod_id) {
        return prodReponsitory.findOne(prod_id);
    }

    public Product saveProduct(Product product) {
        return prodReponsitory.save(product);
    }

    public void deleteProduct(String prod_id) {
    	prodReponsitory.delete(prod_id);
    }
    
    public List<Product> searchProducts(String prod_name) {
        return prodReponsitory.findByProdNameContainingIgnoreCase(prod_name);
    }
}


