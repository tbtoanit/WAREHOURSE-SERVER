package com.toandev;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdReponsitory extends JpaRepository<Product, String> {
	@Query("SELECT p FROM Product p WHERE p.prod_name LIKE %:keyword%")
	List<Product> findByProdNameContainingIgnoreCase(@Param("keyword") String keyword);
	
}
