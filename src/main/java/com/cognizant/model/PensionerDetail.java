package com.cognizant.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PensionerDetail {

	private String aadhaarNumber;
	private String name;
	private String dateOfBirth;
	private String panNumber;
	private double salary;
	private double allowance;
	private String pensionType;
	private BankDetail bankDetail;

}
