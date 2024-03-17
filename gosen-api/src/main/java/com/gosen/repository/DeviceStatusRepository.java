package com.gosen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gosen.model.DeviceStatusEntity;

public interface DeviceStatusRepository extends JpaRepository<DeviceStatusEntity, Long>{
	DeviceStatusEntity findByDeviceNumber(int deviceNumber);
}
