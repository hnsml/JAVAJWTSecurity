package com.example.poemsspringsecuritydemo.repositories;

import com.example.poemsspringsecuritydemo.entities.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByNameContaining(String words);

    @Query("SELECT c FROM Category c ORDER BY c.popularity DESC")
    List<Category> findTopCategories();

    @Query("SELECT c FROM Category c ORDER BY SIZE(c.poems) DESC")
    List<Category> findCategoriesWithMostPoems();
}