/**
 * 
 */
package com.microservices.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author AmmaNanaSatish
 *
 */
@Component
@ConfigurationProperties("limit-service")
public class Configuration {
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
	
}
