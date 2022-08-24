package com.cognizant.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.ProcessPensionException;
import com.cognizant.exception.ResourceNotFoundException;
import com.cognizant.model.AuthRequest;
import com.cognizant.model.PensionDetail;
import com.cognizant.model.PensionerInput;
import com.cognizant.model.Token;
import com.cognizant.restclient.AuthorizationClient;
import com.cognizant.restclient.PensionerDetailClient;
import com.cognizant.service.ProcessPensionService;


@CrossOrigin(origins ={"http://localhost:4200"})
@RestController
public class ProcessPensionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessPensionController.class);
	private PensionerDetailClient pensionerDetailClient;
	private ProcessPensionService processPensionService;
	private AuthorizationClient authorizationClient;


	@Autowired
	public ProcessPensionController(PensionerDetailClient pensionerDetailClient,
			 ProcessPensionService processPensionService,AuthorizationClient authorizationClient) {
		this.pensionerDetailClient = pensionerDetailClient;
		this.processPensionService = processPensionService;
		this.authorizationClient = authorizationClient;
	}

	
	@PostMapping("/token")
	public ResponseEntity<Object> doLogin(@RequestBody AuthRequest authRequest) {
		LOGGER.info("STARTED - doLogin");
		String token = null;
		
		try {
			token = authorizationClient.generateToken(authRequest);
System.out.println(token);
		} catch (Exception e) {
			LOGGER.error("EXCEPTION - doLogin");
			throw new ResourceNotFoundException("token can't be generated");
		}

		LOGGER.debug(token);

		LOGGER.info("END - doLogin");
		return ResponseEntity.ok(new Token(token));
	}

	//generating pension detail with pension amount for given user input
	@PostMapping("/pensionerInput")
	public PensionDetail getPensionDetail(@RequestHeader(name = "Authorization") String token,
			@RequestBody PensionerInput pensionerInput) {
		LOGGER.info("STARTED - allDetail");
		PensionDetail pensionDetail = null;
		try {
			pensionDetail = processPensionService.getPensionDetail(
					pensionerDetailClient.findByAadhaarNumber(token, pensionerInput.getAadhaarNumber()));
					
		} catch (Exception e) {
			LOGGER.error("EXCEPTION - allDetail");
			throw new ProcessPensionException("Pensioner Detail not coreect");
		}
		LOGGER.info("END - allDetail");
		
		return processPensionService.savePensionDetail(pensionDetail);

	}

}
