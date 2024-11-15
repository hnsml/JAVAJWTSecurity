package com.example.poemsspringsecuritydemo.DTOs;

import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PoetDTO {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Biography is mandatory")
    private String biography;

    @NotBlank(message = "Country is mandatory")
    private String country;

    private List<PoemDTO> poems;
}
