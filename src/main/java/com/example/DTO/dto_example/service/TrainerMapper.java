package com.example.DTO.dto_example.service;

import com.example.DTO.dto_example.dto.PokemonDto;
import com.example.DTO.dto_example.dto.TrainerDto;
import com.example.DTO.dto_example.entity.Pokemon;
import com.example.DTO.dto_example.entity.Trainer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerMapper {

    public TrainerDto TransformTrainerEntityInTrainerDto(Trainer trainer)
    {
        TrainerDto trainerDto = new TrainerDto();
        List<PokemonDto> pokemonDtos = new ArrayList<>();

        trainerDto.setName(trainer.getName());

        for (Pokemon pokemon : trainer.getPokemons())
        {
            PokemonDto pokemonDto = new PokemonDto();
            pokemonDto.setName(pokemon.getName());

            pokemonDtos.add(pokemonDto);
        }

        trainerDto.setPokemonDtos(pokemonDtos);

        return trainerDto;
    }
}
