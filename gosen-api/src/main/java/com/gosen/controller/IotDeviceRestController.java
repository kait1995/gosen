package com.gosen.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gosen.config.AppConfig;
import com.gosen.data.DataSet;
import com.gosen.data.DeviceNumberList;
import com.gosen.model.EnvironmentalDataEntity;
import com.gosen.repository.EnvironmentalDataRepository;

@RestController
public class IotDeviceRestController {
	private final AppConfig appConfig;
	private final EnvironmentalDataRepository environmentalDataRepository;
	
	public IotDeviceRestController(AppConfig appConfig, EnvironmentalDataRepository environmentalDataRepository) {
		this.appConfig = appConfig;
		this.environmentalDataRepository = environmentalDataRepository;
	}
	
	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping(value="/v1/device/list", produces="application/json;charset=UTF-8")
	public ResponseEntity<DeviceNumberList> getDeviceNumberList(){
		List<EnvironmentalDataEntity> res = environmentalDataRepository.findAll();
		var deviceNumberList = res.stream().map(EnvironmentalDataEntity::getDeviceNumber).distinct().toList();
		var responseEntity = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new DeviceNumberList(deviceNumberList));
		return responseEntity;
	}
	
	@GetMapping(value="/v1/device/dataset", produces="application/json;charset=UTF-8")
	public ResponseEntity<DataSet> getDeviceDataSet(){	
        var res = environmentalDataRepository.findAll();
        var dateList = res.stream().map(EnvironmentalDataEntity::getDate).toList();
        var measuredValue = res.stream().map((environmentalData) -> {
			return DataSet.MeasuredValue.builder()
					.humidity(environmentalData.getHumidity())
					.temperature(environmentalData.getTemperature())
					.option0(environmentalData.getOption0())
					.option1(environmentalData.getOption1())
					.option2(environmentalData.getOption2())
					.option3(environmentalData.getOption3())
					.option4(environmentalData.getOption4())
					.option5(environmentalData.getOption5())
					.option6(environmentalData.getOption6())
					.option7(environmentalData.getOption7())
					.option8(environmentalData.getOption8())
					.option9(environmentalData.getOption9()).build();
        }).toList();
        var dataSet = DataSet.builder().dateList(dateList).measuredValue(measuredValue).build();
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(dataSet);
    }
	
	@GetMapping(value="/v1/device", produces="application/json;charset=UTF-8")
	public ResponseEntity<List<EnvironmentalDataEntity>> getGraphData(){
		List<EnvironmentalDataEntity> res = environmentalDataRepository.findAll();
		return ResponseEntity.ok(res);
	}
}
