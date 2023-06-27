package com.gosen.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
public class DeviceSetting {
	@Id
	@GeneratedValue
	private Long settingId;
	
	private String title;
	private Long deviceNumber;
	private boolean isActivated;
	private boolean useCamera;
	private boolean useTimer;
	private String timerStart;
	private String timerEnd;
	private boolean manualWatering;
	private boolean status0;
	private boolean status1;
	private boolean status2;
	private boolean status3;
	private boolean status4;
	private boolean status5;
	private boolean status6;
	private boolean status7;
	private boolean status8;
	private boolean status9;
	
	@OneToOne(mappedBy="deviceSetting", cascade=CascadeType.ALL)
	@JsonBackReference
	private GraphData graphData;
}
