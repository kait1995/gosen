package com.gosen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gosen.model.DeviceSetting;

public interface DeviceSettingRepository extends JpaRepository<DeviceSetting, Long>{

}
