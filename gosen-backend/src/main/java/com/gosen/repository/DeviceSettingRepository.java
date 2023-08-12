package com.gosen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gosen.model.DeviceSetting;

public interface DeviceSettingRepository extends JpaRepository<DeviceSetting, Long>{
	boolean existsByTitle(String title);
}
