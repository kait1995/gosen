package com.gosen.data;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataSet {
	private List<String> dateList;
	private List<Double> measuredValues;
}
