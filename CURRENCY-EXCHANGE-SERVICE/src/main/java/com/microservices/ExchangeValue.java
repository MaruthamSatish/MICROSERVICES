/**
 * 
 */
package com.microservices;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author AmmaNanaSatish
 *
 */
@Entity
@Table(name="currency_exchange")
public class ExchangeValue implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
private Long id;
@Column(name="exchangefrom")
private String from;
@Column(name="exchangeto")
private String to;
private BigDecimal multiplevalue;

private int port; 
public ExchangeValue() {
	}

	
	 public int getPort() { return port; }
	
	 public void setPort(int port) { this.port = port; }
	 

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFrom() {
	return from;
}

public void setFrom(String from) {
	this.from = from;
}

public String getTo() {
	return to;
}

public void setTo(String to) {
	this.to = to;
}

public BigDecimal getMultiplevalue() {
	return multiplevalue;
}

public void setMultiplevalue(BigDecimal multiplevalue) {
	this.multiplevalue = multiplevalue;
}

public ExchangeValue(Long id, String from, String to, BigDecimal multiplevalue) {
	super();
	this.id = id;
	this.from = from;
	this.to = to;
	this.multiplevalue = multiplevalue;
}



}
