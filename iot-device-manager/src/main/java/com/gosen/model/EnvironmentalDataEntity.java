package com.gosen.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentalDataEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long dataId;
	
	private int deviceNumber;
	private String batteryStatus;
	private String signalStrength;
	private String humidity;
	private String temperature;
	private String option0;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String option5;
	private String option6;
	private String option7;
	private String option8;
	private String option9;
	private String date;
}
