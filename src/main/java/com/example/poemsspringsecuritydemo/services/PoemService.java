package com.example.poemsspringsecuritydemo.services;

import com.example.poemsspringsecuritydemo.DTOs.PoemDTO;
import com.example.poemsspringsecuritydemo.entities.Poem;
import com.example.poemsspringsecuritydemo.mappers.PoemMapper;
import com.example.poemsspringsecuritydemo.repositories.PoemRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoemService {

    @Autowired
    private PoemRepository poemRepository;

    public PoemDTO getPoem(Long poemId) {
        Poem poem = poemRepository.findById(poemId).orElse(null);
        return PoemMapper.toDto(poem);
    }

    public List<PoemDTO> getPoemsByPoetName(String poetName) {
        return poemRepository.findByPoetName(poetName).stream()
                .map(PoemMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<PoemDTO> getPoemsByPoetNameContainingWords(String poetName, String words) {
        return poemRepository.findByPoetNameAndContentContaining(poetName, words).stream()
                .map(PoemMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<PoemDTO> getFamousPoemsByPoetName(String poetName) {
        return poemRepository.findFamousPoemsByPoetName(poetName).stream()
                .map(PoemMapper::toDto)
                .collect(Collectors.toList());
    }

    public PoemDTO getRandomPoemByPoet(String poetName) {
        Poem poem = poemRepository.findRandomPoemByPoetName(poetName);
        return PoemMapper.toDto(poem);
    }

    public List<PoemDTO> getTopPoemsInCategory(Long categoryId) {
        return poemRepository.findTopPoemsInCategory(categoryId).stream()
                .map(PoemMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<PoemDTO> getTopPoemsAcrossCategories() {
        return poemRepository.findTopPoemsAcrossCategories().stream()
                .map(PoemMapper::toDto)
                .collect(Collectors.toList());
    }
}
