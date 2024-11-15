package com.example.poemsspringsecuritydemo.mappers;

import com.example.poemsspringsecuritydemo.DTOs.CategoryDTO;
import com.example.poemsspringsecuritydemo.entities.Category;

public class CategoryMapper {

    public static CategoryDTO toDto(Category category) {
        if (category == null) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setPopularity(category.getPopularity());
        return categoryDTO;
    }

    public static Category toEntity(CategoryDTO categoryDTO) {
        if (categoryDTO == null) {
            return null;
        }

        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setPopularity(categoryDTO.getPopularity());
        return category;
    }
}