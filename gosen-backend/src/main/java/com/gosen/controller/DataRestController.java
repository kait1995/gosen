package com.gosen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<Long> addItem(@RequestBody DeviceSetting deviceSetting) {
		DeviceSetting res = deviceSettingRepo.save(deviceSetting);
		return ResponseEntity.ok(res.getSettingId());
		/*
		if(deviceSettingRepo.existsByTitle(deviceSetting.getTitle())) {
			return ResponseEntity.badRequest().body("The title is already in use.");
		} else {
			DeviceSetting res = deviceSettingRepo.save(deviceSetting);
			return ResponseEntity.ok(res.getSettingId().toString());
		}
		*/
	}
	
	@GetMapping(value="/v1/system/get", produces="application/json;charset=UTF-8")
	public ResponseEntity<List<DeviceSetting>> getItems(){
		List<DeviceSetting> res = deviceSettingRepo.findAll();
		return ResponseEntity.ok(res);
	}
	
	@PostMapping(value="/v1/system/delete/{id}")
	public ResponseEntity<String> removeItem(@PathVariable("id") Long id){
		var deviceSetting = deviceSettingRepo.findById(id);
		if(deviceSetting != null) {
			deviceSettingRepo.deleteById(id);
			return ResponseEntity.ok("Response ok.");
		} else {
			return ResponseEntity.badRequest().body("The title was not found.");
		}
	}
	
}
