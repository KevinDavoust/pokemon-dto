package com.example.DTO.dto_example.controller;

import com.example.DTO.dto_example.dto.PokemonDto;
import com.example.DTO.dto_example.dto.TrainerDto;
import com.example.DTO.dto_example.entity.Pokemon;
import com.example.DTO.dto_example.entity.Trainer;
import com.example.DTO.dto_example.repository.PokemonRepository;
import com.example.DTO.dto_example.repository.TrainerRepository;
import com.example.DTO.dto_example.service.PokemonMapper;
import com.example.DTO.dto_example.service.RoleMapper;
import com.example.DTO.dto_example.service.TrainerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    private final RoleMapper roleMapper;
    private final PokemonMapper pokemonMapper;
    private final TrainerMapper trainerMapper;

    private final TrainerRepository trainerRepository;
    private final PokemonRepository pokemonRepository;

    public Controller(RoleMapper roleMapper, PokemonMapper pokemonMapper, TrainerMapper trainerMapper, TrainerRepository trainerRepository, PokemonRepository pokemonRepository) {
        this.roleMapper = roleMapper;
        this.pokemonMapper = pokemonMapper;
        this.trainerMapper = trainerMapper;
        this.trainerRepository = trainerRepository;
        this.pokemonRepository = pokemonRepository;
    }


    @GetMapping("/trainers")
    public List<Trainer> getTrainers()
    {
        return trainerRepository.findAll();
    }

    @PostMapping("/trainers")
    public Trainer addTrainer(@RequestBody Trainer trainer)
    {
        return trainerRepository.save(trainer);
    }

    @GetMapping("/trainers/{id}/pokemons")
    public ResponseEntity<?> getPokemonsOfTrainer(@PathVariable("id") Long id)
    {
        Optional<Trainer> oTrainer = trainerRepository.findById(id);

        if (oTrainer.isPresent()) {
            Trainer trainer = oTrainer.get();

            List<Pokemon> pokemons = trainer.getPokemons();

            List<PokemonDto> pokemonDtos = new ArrayList<>();

            for (Pokemon pokemon : pokemons) {
                PokemonDto pokemonDto = pokemonMapper.TransformPokemonEntityInPokemonDto(pokemon);
                pokemonDtos.add(pokemonDto);
            }

            TrainerDto trainerDto = trainerMapper.TransformTrainerEntityInTrainerDto(trainer);
            trainerDto.setPokemonDtos(pokemonDtos);

            return new ResponseEntity<>(trainerDto, HttpStatus.OK);
    }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/pokemons")
    public List<Pokemon> getPokemons()
    {
        return pokemonRepository.findAll();
    }

    @PostMapping("/pokemons")
    public Pokemon addPokemon(@RequestBody Pokemon pokemon)
    {
        return pokemonRepository.save(pokemon);
    }

    @GetMapping("/pokemons/{name}")
    public ResponseEntity<?> searchPokemonByName(@PathVariable("name") String name)
    {
        if (name != null ) {
            Pokemon pokemon = pokemonRepository.findPokemonByName(name);

            PokemonDto pokemonDto = pokemonMapper.TransformPokemonEntityInPokemonDto(pokemon);

            return new ResponseEntity<>(pokemonDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
