package com.gosen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gosen.model.EnvironmentalData;

public interface EnvironmentalDataRepository extends JpaRepository<EnvironmentalData, Long>{
}
