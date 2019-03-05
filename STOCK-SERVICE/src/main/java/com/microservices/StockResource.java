/**
 * 
 */
package com.microservices;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

/**
 * @author AmmaNanaSatish
 *
 */
@RestController
@RequestMapping("api/stock")
public class StockResource {
	private static final Logger logger = LoggerFactory.getLogger(StockResource.class);

	@Autowired
	DBStockServiceProxy dbStockProxy;
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/{username}")
	public List<Stock> getQuotes(@PathVariable("username") final String username){
		System.out.println("Demo"+username);
		return dbStockProxy.findByUserName(username).stream().map(this::getStockPrice).collect(Collectors.toList());
	   }
	@GetMapping("rest/{username}")
	public List<Stock> getStock(@PathVariable("username") final String username){
		logger.info(username);
	ResponseEntity<List<String>> responseEntity=restTemplate.exchange("http://localhost:8083/rest/db/"+username, HttpMethod.GET, 
			null,new ParameterizedTypeReference <List<String>>() {
	});
	List<String>quotes=responseEntity.getBody();
	return quotes
			.stream()
			.map(this::getStockPrice)
			.collect(Collectors.toList());
   }
    private Stock getStockPrice(String quote) {
		try {
			return YahooFinance.get(quote);
		} catch (IOException e) {
			e.printStackTrace();
			return new Stock(quote);
		   }
		 }
    }
