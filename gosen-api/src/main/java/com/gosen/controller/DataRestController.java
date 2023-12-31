package com.gosen.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gosen.config.AppConfig;
import com.gosen.model.DeviceSettingEntity;
import com.gosen.repository.DeviceSettingRepository;

@RestController
public class DataRestController {
	
	private final AppConfig appConfig;	
	private final DeviceSettingRepository deviceSettingRepo;
	
	DataRestController(DeviceSettingRepository deviceSettingRepo, AppConfig appConfig){
		this.deviceSettingRepo = deviceSettingRepo;
		this.appConfig = appConfig;
	}
	
	@PostMapping(value="/v1/item", consumes="application/json;charset=UTF-8")
	public ResponseEntity<Long> addItem(@RequestBody DeviceSettingEntity deviceSetting) {
		DeviceSettingEntity res = deviceSettingRepo.save(deviceSetting);
		return ResponseEntity.ok(res.getSettingId());
	}
	
	@PutMapping(value="/v1/item/{id}")
	public ResponseEntity<String> updateItem(
			@PathVariable("id") Long id,
			@RequestBody DeviceSettingEntity deviceSetting
	){
		var res = deviceSettingRepo.findById(id);
		if(res.isPresent()) {
			res.get().setDeviceNumber(deviceSetting.getDeviceNumber());
			res.get().setTitle(deviceSetting.getTitle());
			deviceSettingRepo.save(res.get());
			return ResponseEntity.ok("Response ok");
		} else {
			return ResponseEntity.badRequest().body("");
		}
	}
	
	@DeleteMapping(value="/v1/item/{id}")
	public ResponseEntity<String> removeItem(@PathVariable("id") Long id){
		var deviceSetting = deviceSettingRepo.findById(id);
		if(deviceSetting.isPresent()) {
			deviceSettingRepo.deleteById(id);
			return ResponseEntity.ok("Response ok.");
		} else {
			return ResponseEntity.badRequest().body("The title was not found.");
		}
	}
	
	@GetMapping(value="/v1/item", produces="application/json;charset=UTF-8")
	public ResponseEntity<List<DeviceSettingEntity>> getItems(){
		List<DeviceSettingEntity> res = deviceSettingRepo.findAll();
		return ResponseEntity.ok(res);
	}
	
}
