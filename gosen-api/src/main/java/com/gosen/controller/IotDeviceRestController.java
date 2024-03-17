package com.gosen.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gosen.data.DataSet;
import com.gosen.data.DataType;
import com.gosen.data.DeviceNumberList;
import com.gosen.data.EnvironmentalData;
import com.gosen.model.EnvironmentalDataEntity;
import com.gosen.model.DeviceStatusEntity;
import com.gosen.repository.DeviceStatusRepository;
import com.gosen.repository.EnvironmentalDataRepository;

@RestController
public class IotDeviceRestController {
	private final EnvironmentalDataRepository environmentalDataRepository;
	private final DeviceStatusRepository deviceStatusRepository;
	
	public IotDeviceRestController(EnvironmentalDataRepository environmentalDataRepository, DeviceStatusRepository deviceStatusRepository) {
		this.environmentalDataRepository = environmentalDataRepository;
		this.deviceStatusRepository = deviceStatusRepository;
	}
	
	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping(value="/v1/device/id/list", produces="application/json;charset=UTF-8")
	public ResponseEntity<DeviceNumberList> getDeviceNumberList(){
		List<DeviceStatusEntity> res = deviceStatusRepository.findAll();
		var deviceNumberList = res.stream().map(DeviceStatusEntity::getDeviceNumber).distinct().toList();
		var responseEntity = ResponseEntity.ok().body(new DeviceNumberList(deviceNumberList));
		return responseEntity;
	}
	
	@GetMapping(value="/v1/device/dataset/{id}/{dataType}", produces="application/json;charset=UTF-8")
	public ResponseEntity<DataSet> getDeviceDataSet(@PathVariable("id") int id, @PathVariable("dataType") String dataType){
		var targetDevice = deviceStatusRepository.findByDeviceNumber(id);
		var environmentalData = environmentalDataRepository.findAllByStatusId(targetDevice)
				.stream()
				.filter(data -> data.getDataType().equals(dataType))
				.map(EnvironmentalDataEntity::getDataValue)
				.toList();
		var date = environmentalDataRepository.findAllByStatusId(targetDevice)
				.stream()
				.filter(data -> data.getDataType().equals(dataType))
				.map(EnvironmentalDataEntity::getDate)
				.toList();
		return ResponseEntity.ok().body(DataSet.builder().dateList(date).measuredValues(environmentalData).build());
	}
	
	@GetMapping(value="/v1/device/datatype", produces="application/json;charset=UTF-8")
	public ResponseEntity<DataType> getDataTypes(){
		List<EnvironmentalDataEntity> res = environmentalDataRepository.findAll();
		var dataType = res.stream().map(EnvironmentalDataEntity::getDataType).distinct().toList();
		var responseEntity = ResponseEntity.ok().body(new DataType(dataType));
		return responseEntity;
	}

}
