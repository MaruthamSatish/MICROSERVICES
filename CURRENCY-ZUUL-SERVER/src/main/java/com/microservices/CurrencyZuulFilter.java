package com.microservices;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;



public class CurrencyZuulFilter extends com.netflix.zuul.ZuulFilter{
private Logger logger=LoggerFactory.getLogger(this.getClass());
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	public Object run() throws ZuulException {
		HttpServletRequest httpServlet=RequestContext.getCurrentContext().getRequest();
		System.out.println("Zuul Filter"+httpServlet.getRequestURI().toString());
		logger.info("{}", httpServlet,httpServlet.getRequestURI().toString());
		return null;
	}

	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
