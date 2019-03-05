/**
 * 
 */
package com.microservices;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author AmmaNanaSatish
 * @param <Quote>
 *
 */
@FeignClient(name="db-stock-service-1",url="localhost:8083")
public interface DBStockServiceProxy {
	@GetMapping("/{username}")
	public List<String> findByUserName(@PathVariable("username") final String username);
}
