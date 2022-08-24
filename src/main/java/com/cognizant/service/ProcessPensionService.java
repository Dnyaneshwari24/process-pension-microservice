package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Bank;
import com.cognizant.model.PensionDetail;
import com.cognizant.model.PensionerDetail;
import com.cognizant.repository.PensionDetailRepository;
import com.cognizant.helper.ProcessPensionHelper;

@Service
public class ProcessPensionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessPensionService.class);
	private PensionDetailRepository pensionDetailRepository;
	private ProcessPensionHelper helper;
	PensionDetail pensionDetail;
	@Autowired
	public ProcessPensionService(PensionDetailRepository pensionDetailRepository) {
		this.pensionDetailRepository = pensionDetailRepository;
	}

	
	
	public List<Bank> getBankInfo(){
		List<Bank> bankList=new ArrayList<>();
		bankList.add(new Bank("SBI","public",500));
		bankList.add(new Bank("HDFC","private",550));
		bankList.add(new Bank("KOTAK","private",550));
		bankList.add(new Bank("IDBI","public",500));
		bankList.add(new Bank("HSBC","private",550));
		bankList.add(new Bank("CityBank","private",550));
		bankList.add(new Bank("ICICI","public",500));
		return bankList;
	}
	// calculating pension detail and saving to database

	public PensionDetail getPensionDetail(PensionerDetail pensionerDetail) {
		
		LOGGER.info("STARTED - getPensionDetail");
		double pensionAmount = 0;
		int bankServiceCharge=0;
		if (pensionerDetail.getPensionType().equalsIgnoreCase("self")) {
			pensionAmount = (0.8 * pensionerDetail.getSalary() + pensionerDetail.getAllowance());
		} else if (pensionerDetail.getPensionType().equalsIgnoreCase("family")) {
			pensionAmount = (0.5 * pensionerDetail.getSalary() + pensionerDetail.getAllowance());
		}
		
		List<Bank> bankList=getBankInfo();
		for(Bank b:bankList) {
			if (pensionerDetail.getBankDetail().getBankType().equalsIgnoreCase(b.getBankType())) {
				bankServiceCharge=b.getBankServiceCharge();
			}
		}
		pensionDetail = new PensionDetail(pensionAmount,bankServiceCharge);

		LOGGER.info("END - getPensionDetail");
		return pensionDetail;

	}
	
	
	public PensionDetail savePensionDetail(PensionDetail pensionDetail) {
		LOGGER.info("STARTED - savePensionDetail");
		LOGGER.info("END - savePensionDetail");
		return pensionDetailRepository.save(pensionDetail);

	}

}
