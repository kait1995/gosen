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
	}
	
	private List<String> dateList;
	private List<MeasuredValue> measuredValues;
}
