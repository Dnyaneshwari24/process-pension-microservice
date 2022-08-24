package com.cognizant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PensionDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double pensionAmount;
	private int bankServiceCharge;
	
	public PensionDetail(double pensionAmount,int bankServiceCharge) {
		super();
		this.pensionAmount = pensionAmount;
		this.bankServiceCharge=bankServiceCharge;
	}
	
	

	
	

}
