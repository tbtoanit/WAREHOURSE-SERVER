package com.toandev.danhmuc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryReponsitory extends JpaRepository<Category, Integer> {
   /* void deleteByCateId(int cateId);*/

    @Query("SELECT c FROM Category c WHERE c.cateName LIKE %:keyword%")

    List<Category> findByCateNameContainingIgnoreCase(@Param("keyword") String keyword);
}




