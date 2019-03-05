package com.microservices.model;

public class LimitConfiguration {

	private int maxValue;
	private int minimumValue;
	public int getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
	public int getMinimumValue() {
		return minimumValue;
	}
	public void setMinimumValue(int minimumValue) {
		this.minimumValue = minimumValue;
	}
	public LimitConfiguration(int maxValue, int minimumValue) {
		super();
		this.maxValue = maxValue;
		this.minimumValue = minimumValue;
	}
	
}
