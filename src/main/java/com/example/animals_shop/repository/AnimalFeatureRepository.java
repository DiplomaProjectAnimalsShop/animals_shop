package com.example.animals_shop.repository;

import com.example.animals_shop.model.AnimalFeature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalFeatureRepository extends JpaRepository<AnimalFeature, Integer> {
}