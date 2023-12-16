package com.gosen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gosen.model.DeviceSettingEntity;

public interface DeviceSettingRepository extends JpaRepository<DeviceSettingEntity, Long>{
	boolean existsByTitle(String title);
	DeviceSettingEntity findByTitle(String title);
}
