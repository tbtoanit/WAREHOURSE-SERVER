package com.toandev.khohang;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

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

    public List<Product> searchProductId(String prod_id) {
        return prodReponsitory.findByProdIdContainingIgnoreCase(prod_id);
    }

    public void updateProductInformation(String prod_id, Product updatedProduct) {
        Product existingProduct = prodReponsitory.findByProdId(prod_id);
        if (existingProduct != null) {
            // Cập nhật thông tin sản phẩm
            if (updatedProduct.getProd_id() != null) {
                existingProduct.setProd_id(updatedProduct.getProd_id());
            }
            if (updatedProduct.getProd_name() != null) {
                existingProduct.setProd_name(updatedProduct.getProd_name());
            }
            if (updatedProduct.getProd_cate_id() != null) {
                existingProduct.setProd_cate_id(updatedProduct.getProd_cate_id());
            }
            if (updatedProduct.getProd_weight() != null) {
                existingProduct.setProd_weight(updatedProduct.getProd_weight());
            }
            if (updatedProduct.getProd_weight_unit() != null) {
                existingProduct.setProd_weight_unit(updatedProduct.getProd_weight_unit());
            }
            // Lưu lại vào cơ sở dữ liệu
            prodReponsitory.save(existingProduct);
        } else {
            throw new EntityNotFoundException("Không tìm thấy sản phẩm với ID: " + prod_id);
        }
    }
}


