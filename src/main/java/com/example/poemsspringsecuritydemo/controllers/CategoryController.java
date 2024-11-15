package com.example.poemsspringsecuritydemo.controllers;

import com.example.poemsspringsecuritydemo.DTOs.CategoryDTO;
import com.example.poemsspringsecuritydemo.DTOs.PoemDTO;
import com.example.poemsspringsecuritydemo.services.CategoryService;
import com.example.poemsspringsecuritydemo.services.PoemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PoemService poemService;

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/search")
    public List<CategoryDTO> getCategoriesContainingWords(@RequestParam String words) {
        return categoryService.getCategoriesContainingWords(words);
    }

    @GetMapping("/top")
    public List<CategoryDTO> getTopCategories() {
        return categoryService.getTopCategories();
    }

    @GetMapping("/most-poems")
    public List<CategoryDTO> getCategoriesWithMostPoems() {
        return categoryService.getCategoriesWithMostPoems();
    }

    @GetMapping("/{categoryId}/poems/top")
    public List<PoemDTO> getTopPoemsInCategory(@PathVariable Long categoryId) {
        return poemService.getTopPoemsInCategory(categoryId);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDTO categoryDto) {
        categoryService.addCategory(categoryDto);
        return ResponseEntity.ok("Category added successfully.");
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully.");
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> updateCategory(@PathVariable Long id,
            @RequestBody CategoryDTO categoryDto) {
        categoryService.updateCategory(id, categoryDto);
        return ResponseEntity.ok("Category updated successfully.");
    }
}
