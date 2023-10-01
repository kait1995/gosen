package com.gosen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.gosen.model.DeviceSetting;
import com.gosen.repository.DeviceSettingRepository;

@RestController
public class DataRestController {
	/*
	 * [API]
	 * /v1/system/add
	 * /v1/system/delete/:title
	 * /v1/system/update/:title
	 * /v1/system/search/:title
	 * /v1/system/info/:id/get
	 * /v1/device/:id/add
	 * /v1/device/:id/get/status
	 * /v1/device/:id/suspend
	 * /v1/device/:id/resume
	*/
	
	private final DeviceSettingRepository deviceSettingRepo;
	
	DataRestController(DeviceSettingRepository deviceSettingRepo){
		this.deviceSettingRepo = deviceSettingRepo;
	}
	
	@PostMapping(value="/v1/system/add", consumes="application/json;charset=UTF-8")
	public ResponseEntity<String> addItem(@RequestBody DeviceSetting deviceSetting) {
		if(deviceSettingRepo.existsByTitle(deviceSetting.getTitle())) {
			return new ResponseEntity<>("The title is already in use.", HttpStatus.BAD_REQUEST);
		} else {
			deviceSettingRepo.save(deviceSetting);
			return ResponseEntity.ok("Response ok.");
		}
	}
	
	@PostMapping(value="/v1/system/delete/{title}")
	public ResponseEntity<String> removeItem(@PathVariable("title") String title){
		var deviceSetting = deviceSettingRepo.findByTitle(title);
		if(deviceSetting != null) {
			deviceSettingRepo.delete(deviceSetting);
			return ResponseEntity.ok("Response ok.");
		} else {
			return ResponseEntity.badRequest().body("The title was not found.");
		}
	}
	
}
