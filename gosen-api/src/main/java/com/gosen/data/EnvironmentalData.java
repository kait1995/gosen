package com.gosen.data;

import java.util.List;

import com.gosen.model.EnvironmentalDataEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnvironmentalData {
	private List<EnvironmentalDataEntity> environmentalData;
}
