package com.example.poemsspringsecuritydemo.repositories;

import com.example.poemsspringsecuritydemo.entities.Poem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PoemRepository extends JpaRepository<Poem, Long> {

    List<Poem> findByPoetName(String poetName);

    List<Poem> findByPoetNameAndContentContaining(String poetName, String words);

    @Query("SELECT p FROM Poem p WHERE p.poet.name = :poetName ORDER BY p.rating DESC")
    List<Poem> findFamousPoemsByPoetName(String poetName);

    @Query(value = "SELECT * FROM poems WHERE poet_name = :poetName ORDER BY random() LIMIT 1", nativeQuery = true)
    Poem findRandomPoemByPoetName(String poetName);

    @Query("SELECT p FROM Poem p WHERE p.category.id = :categoryId ORDER BY p.rating DESC")
    List<Poem> findTopPoemsInCategory(Long categoryId);

    @Query("SELECT p FROM Poem p ORDER BY p.rating DESC")
    List<Poem> findTopPoemsAcrossCategories();
}
