package com.example.DTO.dto_example.dto;

import java.util.List;

public class TrainerDto {

    private String name;
    private List<PokemonDto> pokemonDtos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PokemonDto> getPokemonDtos() {
        return pokemonDtos;
    }

    public void setPokemonDtos(List<PokemonDto> pokemonDtos) {
        this.pokemonDtos = pokemonDtos;
    }
}
