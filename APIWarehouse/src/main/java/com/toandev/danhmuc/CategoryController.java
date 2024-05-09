package com.toandev.danhmuc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllCategories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/saveCate")
    public ResponseEntity<String> saveCate(@RequestBody Category category){
        try{
            categoryService.saveCate(category);
            return ResponseEntity.ok("Save success");
        }catch (Exception e) {
            return ResponseEntity.ok("Failed to save Cate: " + e.getMessage());
        }
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/updateCate/{cateId}")
    public ResponseEntity<String> updateCate(@PathVariable int cateId, @RequestBody Category updatedCategory) {
        try {
            // Gọi phương thức service để cập nhật danh mục
            categoryService.updateCate(cateId, updatedCategory);
            return ResponseEntity.ok("Update success");
        } catch (Exception e) {
            return ResponseEntity.ok("Failed to update category: " + e.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
   @PostMapping("/deleteCate")
   public ResponseEntity<String> delProd (@RequestBody Category category) {
       try {
           categoryService.deleteCategory(category.getCateId());
           return ResponseEntity.ok ("Category delete successfully");
       }catch (Exception e) {
           return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete .");
       }
   }


        @CrossOrigin(origins = "http://localhost:3000")
        @PostMapping("/searchCate")
        public ResponseEntity<List<Category>> searchCategories(@RequestParam String cateName) {
            try {
                List<Category> categories = categoryService.searchCategories(cateName);
                return ResponseEntity.ok(categories);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }


}

