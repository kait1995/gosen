package com.gosen.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DeviceStatusEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long statusId;
	
	@Column(unique=true)
	private int deviceNumber;
	
	private double batteryStatus;
	private double signalStrength;
	
	@OneToMany(mappedBy="statusId", cascade=CascadeType.ALL)
	@JsonBackReference
	private List<EnvironmentalDataEntity> environmentalData;
}
