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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
	
	@ManyToOne
	@JoinColumn(name="statusId")
	private DeviceStatusEntity statusId;
	
	private String dataType;
	private double dataValue;
	private String date;
}
