package com.example.poemsspringsecuritydemo.mappers;

import com.example.poemsspringsecuritydemo.DTOs.PoemDTO;
import com.example.poemsspringsecuritydemo.entities.Category;
import com.example.poemsspringsecuritydemo.entities.Poem;
import com.example.poemsspringsecuritydemo.entities.Poet;

public class PoemMapper {

    public static PoemDTO toDto(Poem poem) {
        if (poem == null) {
            return null;
        }

        PoemDTO poemDTO = new PoemDTO();
        poemDTO.setId(poem.getId());
        poemDTO.setTitle(poem.getTitle());
        poemDTO.setContent(poem.getContent());
        poemDTO.setRating(poem.getRating());
        poemDTO.setPoetId(poem.getPoet().getId());
        poemDTO.setPoetName(poem.getPoet().getName());
        poemDTO.setCategoryId(poem.getCategory().getId());
        poemDTO.setCategoryName(poem.getCategory().getName());
        return poemDTO;
    }

    public static Poem toEntity(PoemDTO poemDTO) {
        if (poemDTO == null) {
            return null;
        }

        Poem poem = new Poem();
        poem.setId(poemDTO.getId());
        poem.setTitle(poemDTO.getTitle());
        poem.setContent(poemDTO.getContent());
        poem.setRating(poemDTO.getRating());

        Poet poet = new Poet();
        poet.setId(poemDTO.getPoetId());
        poet.setName(poemDTO.getPoetName());
        poem.setPoet(poet);

        Category category = new Category();
        category.setId(poemDTO.getCategoryId());
        category.setName(poemDTO.getCategoryName());
        poem.setCategory(category);

        return poem;
    }
}