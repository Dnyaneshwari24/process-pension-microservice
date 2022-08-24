package com.cognizant.helper;

import org.springframework.stereotype.Component;
import com.cognizant.model.PensionerDetail;
import com.cognizant.model.PensionerInput;

@Component
public class ProcessPensionHelper {

	public PensionerDetail convertToPensionerDetailEntity(PensionerInput pensionerInput) {

		return PensionerDetail.builder().
				name(pensionerInput.getName())
				.aadhaarNumber(pensionerInput.getAadhaarNumber())
				.dateOfBirth(pensionerInput.getDateOfBirth())
				.panNumber(pensionerInput.getPanNumber())
				.pensionType(pensionerInput.getPensionType())
				.build();
	}
}
