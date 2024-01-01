package com.gosen.data;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataSet {
	@Data
	@Builder
	public static class MeasuredValue{
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
	}
	
	private List<String> dateList;
	private List<MeasuredValue> measuredValues;
}
