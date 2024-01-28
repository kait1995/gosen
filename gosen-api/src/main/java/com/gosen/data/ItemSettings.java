package com.gosen.data;

import java.util.List;

import com.gosen.model.ItemSettingEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemSettings {
	private List<ItemSettingEntity> itemSettings;
}
