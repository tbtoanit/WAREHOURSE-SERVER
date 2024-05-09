package com.toandev.khohang;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdReponsitory extends JpaRepository<Product, String> {
	@Query("SELECT p FROM Product p WHERE p.prod_id = :keyword")
	Product findByProdId(@Param("keyword") String keyword);
	@Query("SELECT p FROM Product p WHERE p.prod_name LIKE %:keyword%")
	List<Product> findByProdNameContainingIgnoreCase(@Param("keyword") String keyword);

	@Query("SELECT p FROM Product p WHERE p.prod_id LIKE %:keyword%")
	List<Product> findByProdIdContainingIgnoreCase(@Param("keyword") String keyword);
}