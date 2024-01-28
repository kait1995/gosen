package com.gosen.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gosen.config.AppConfig;
import com.gosen.data.ItemSettings;
import com.gosen.model.ItemSettingEntity;
import com.gosen.repository.ItemSettingRepository;

@RestController
public class ItemRestController {
	
	private final AppConfig appConfig;	
	private final ItemSettingRepository itemSettingRepo;
	
	ItemRestController(ItemSettingRepository itemSettingRepo, AppConfig appConfig){
		this.itemSettingRepo = itemSettingRepo;
		this.appConfig = appConfig;
	}
	
	@PostMapping(value="/v1/item", consumes="application/json;charset=UTF-8")
	public ResponseEntity<Long> addItem(@RequestBody ItemSettingEntity deviceSetting) {
		ItemSettingEntity res = itemSettingRepo.save(deviceSetting);
		return ResponseEntity.ok().body(res.getSettingId());
	}
	
	@PutMapping(value="/v1/item/{id}")
	public ResponseEntity<String> updateItem(
			@PathVariable("id") Long id,
			@RequestBody ItemSettingEntity deviceSetting
	){
		var res = itemSettingRepo.findById(id);
		if(res.isPresent()) {
			res.get().setDeviceNumber(deviceSetting.getDeviceNumber());
			res.get().setTitle(deviceSetting.getTitle());
			itemSettingRepo.save(res.get());
			return ResponseEntity.ok().body("Response ok");
		} else {
			return ResponseEntity.badRequest().body("");
		}
	}
	
	@DeleteMapping(value="/v1/item/{id}")
	public ResponseEntity<String> removeItem(@PathVariable("id") Long id){
		var deviceSetting = itemSettingRepo.findById(id);
		if(deviceSetting.isPresent()) {
			itemSettingRepo.deleteById(id);
			return ResponseEntity.ok().body("Response ok.");
		} else {
			return ResponseEntity.badRequest().body("The title was not found.");
		}
	}
	
	@GetMapping(value="/v1/item", produces="application/json;charset=UTF-8")
	public ResponseEntity<ItemSettings> getItems(){
		List<ItemSettingEntity> res = itemSettingRepo.findAll();
		return ResponseEntity.ok().body(ItemSettings.builder().itemSettings(res).build());
	}
	
}
