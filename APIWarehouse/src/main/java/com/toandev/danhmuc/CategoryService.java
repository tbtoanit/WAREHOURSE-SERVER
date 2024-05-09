package com.toandev.danhmuc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private  CategoryReponsitory categoryReponsitory;

    public List<Category> getAllCategories() {
        return categoryReponsitory.findAll();
    }
    public  Category saveCate(Category category){
        return categoryReponsitory.save(category);
    }

    public void deleteCategory(int cateId) {
        categoryReponsitory.delete(cateId);
    }
    public List<Category> searchCategories(String cateName) {
        return categoryReponsitory.findByCateNameContainingIgnoreCase(cateName);
    }

    @Transactional
    public void updateCate(int cateId, Category updatedCategory) {
        // Thiết lập cateId cho updatedCategory
        updatedCategory.setCateId(cateId);

        // Lưu updatedCategory vào cơ sở dữ liệu
        categoryReponsitory.save(updatedCategory);
    }


}
