package com.example.poemsspringsecuritydemo.services;

import com.example.poemsspringsecuritydemo.DTOs.CategoryDTO;
import com.example.poemsspringsecuritydemo.entities.Category;
import com.example.poemsspringsecuritydemo.mappers.CategoryMapper;
import com.example.poemsspringsecuritydemo.repositories.CategoryRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<CategoryDTO> getCategoriesContainingWords(String words) {
        return categoryRepository.findByNameContaining(words).stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<CategoryDTO> getTopCategories() {
        return categoryRepository.findTopCategories().stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<CategoryDTO> getCategoriesWithMostPoems() {
        return categoryRepository.findCategoriesWithMostPoems().stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public Category addCategory(CategoryDTO categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setPopularity(categoryDto.getPopularity());
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public Category updateCategory(Long id, CategoryDTO categoryDto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(categoryDto.getName());
        category.setPopularity(categoryDto.getPopularity());
        return categoryRepository.save(category);
    }
}


