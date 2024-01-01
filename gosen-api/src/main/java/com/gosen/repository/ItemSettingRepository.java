package com.gosen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gosen.model.ItemSettingEntity;

public interface ItemSettingRepository extends JpaRepository<ItemSettingEntity, Long>{
	boolean existsByTitle(String title);
	ItemSettingEntity findByTitle(String title);
}
