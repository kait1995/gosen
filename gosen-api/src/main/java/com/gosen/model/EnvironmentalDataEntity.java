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
	private double batteryStatus;
	private double signalStrength;
	private double humidity;
	private double temperature;
	private double option0;
	private double option1;
	private double option2;
	private double option3;
	private double option4;
	private double option5;
	private double option6;
	private double option7;
	private double option8;
	private double option9;
	private String date;
}
