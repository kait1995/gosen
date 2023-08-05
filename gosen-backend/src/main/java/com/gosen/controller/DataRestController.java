package com.gosen.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gosen.model.DeviceSetting;
import com.gosen.repository.DeviceSettingRepository;

@RestController
public class DataRestController {
	/*
	 * [API]
	 * /v1/system/add
	 * /v1/system/delete/:id
	 * /v1/system/update/:id
	 * /v1/system/search/:title
	 * /v1/system/info/:id/get
	 * /v1/devices/:id/get/status
	 * /v1/devices/:id/suspend
	 * /v1/devices/:id/resume
	*/
	
	private final DeviceSettingRepository deviceSettingRepo;
	
	DataRestController(DeviceSettingRepository deviceSettingRepo){
		this.deviceSettingRepo = deviceSettingRepo;
	}
	
	@PostMapping(value="/v1/system/add", consumes="application/json;charset=UTF-8")
	public String addItem(@RequestBody DeviceSetting deviceSetting) {
		deviceSettingRepo.save(deviceSetting);
		return "Test OK";
	}
	
}
