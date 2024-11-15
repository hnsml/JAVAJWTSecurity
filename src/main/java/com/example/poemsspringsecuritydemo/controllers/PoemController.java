package com.example.poemsspringsecuritydemo.controllers;

import com.example.poemsspringsecuritydemo.DTOs.PoemDTO;
import com.example.poemsspringsecuritydemo.services.PoemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/poems")
public class PoemController {

    @Autowired
    private PoemService poemService;

    @GetMapping("/{poemId}")
    public PoemDTO getPoem(@PathVariable Long poemId) {
        return poemService.getPoem(poemId);
    }

    @GetMapping("/by-poet/{poetName}")
    public List<PoemDTO> getPoemsByPoetName(@PathVariable String poetName) {
        return poemService.getPoemsByPoetName(poetName);
    }

    @GetMapping("/by-poet/{poetName}/search")
    public List<PoemDTO> getPoemsByPoetNameContainingWords(@PathVariable String poetName,
            @RequestParam String words) {
        return poemService.getPoemsByPoetNameContainingWords(poetName, words);
    }

    @GetMapping("/by-poet/{poetName}/famous")
    public List<PoemDTO> getFamousPoemsByPoetName(@PathVariable String poetName) {
        return poemService.getFamousPoemsByPoetName(poetName);
    }

    @GetMapping("/by-poet/{poetName}/random")
    public PoemDTO getRandomPoemByPoet(@PathVariable String poetName) {
        return poemService.getRandomPoemByPoet(poetName);
    }

    @GetMapping("/top")
    public List<PoemDTO> getTopPoemsAcrossCategories() {
        return poemService.getTopPoemsAcrossCategories();
    }
}
