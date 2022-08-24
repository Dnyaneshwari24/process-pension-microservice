package com.cognizant.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.PensionerDetail;

@FeignClient(name = "PensionerDetailService", url = "http://localhost:9081")
public interface PensionerDetailClient {
	
	@GetMapping("/pensionerDetail/{aadhaarNumber}")
	public PensionerDetail findByAadhaarNumber(@RequestHeader("Authorization") String token1,  @PathVariable String aadhaarNumber);

	
	
}
