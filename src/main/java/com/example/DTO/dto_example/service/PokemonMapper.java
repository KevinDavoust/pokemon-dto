package com.example.DTO.dto_example.service;

import com.example.DTO.dto_example.dto.PokemonDto;
import com.example.DTO.dto_example.entity.Pokemon;
import org.springframework.stereotype.Service;

@Service
public class PokemonMapper {

    public PokemonDto TransformPokemonEntityInPokemonDto(Pokemon pokemon)
    {
        PokemonDto pokemonDto = new PokemonDto();

        pokemonDto.setName(pokemon.getName());
        pokemonDto.setAttribute(pokemon.getAttribute());

        return pokemonDto;
    }
}
