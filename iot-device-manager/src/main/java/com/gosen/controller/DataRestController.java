package com.gosen.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gosen.model.EnvironmentalDataEntity;
import com.gosen.repository.EnvironmentalDataRepository;

@RestController
public class DataRestController {
	
	private final EnvironmentalDataRepository environmentalDataRepository;
	
	DataRestController(EnvironmentalDataRepository environmentalDataRepository) {
		this.environmentalDataRepository = environmentalDataRepository;
	}
	
	@GetMapping(value="/v1/device", produces="application/json;charset=UTF-8")
	public ResponseEntity<List<EnvironmentalDataEntity>> getGraphData(){
		List<EnvironmentalDataEntity> res = environmentalDataRepository.findAll();
		return ResponseEntity.ok(res);
	}
}
