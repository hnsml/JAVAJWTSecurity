package com.example.poemsspringsecuritydemo.repositories;

import com.example.poemsspringsecuritydemo.entities.Poet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PoetRepository extends JpaRepository<Poet, Long> {

    Poet findByName(String name);

    @Query("SELECT p FROM Poet p ORDER BY p.popularity DESC")
    List<Poet> findTopPoets();

    @Query("SELECT p FROM Poet p WHERE p.country = :country ORDER BY p.popularity DESC")
    List<Poet> findTopPoetsByCountry(String country);
}
