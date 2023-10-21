package com.example.DTO.dto_example.repository;

import com.example.DTO.dto_example.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    Pokemon findPokemonByName(String name);
}
