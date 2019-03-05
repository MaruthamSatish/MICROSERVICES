/**
 * 
 */
package com.microservices.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.model.Configuration;
import com.microservices.model.LimitConfiguration;

/**
 * @author AmmaNanaSatish
 *
 */
@RestController
	public class LimitConfigResources {
	@Autowired	
    private Configuration config;
	@GetMapping("/limit")
	public LimitConfiguration getLimitConfigurations() {
		return new LimitConfiguration(config.getMaxValue(),config.getMinimumValue());
		
	}
}
