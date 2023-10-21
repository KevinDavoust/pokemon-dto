package com.example.DTO.dto_example.repository;

import com.example.DTO.dto_example.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
