package com.cognizant.model.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.model.BankDetail;
import com.cognizant.model.PensionDetail;
import com.cognizant.model.PensionerDetail;

@SpringBootTest
 class PensionerDetailTest {

	PensionerDetail pensionerDetails = new PensionerDetail();
	BankDetail bankDetail = new BankDetail() ;

	@Test
	 void PensionerDetailBeanTest() {
		assertNotNull(pensionerDetails);
	}
	@Test
	 void BankDetailBeanTest() {
		assertNotNull(bankDetail);
	}

	@Test
	 void PensionerDetailNoArgConstructorTest() {
		PensionerDetail pensionerDetails1 = new PensionerDetail();
		assertThat(pensionerDetails1).isNotNull();

	}

	@Test
	 void PensionerDetailAllArgConstructorTest() {
		PensionerDetail pensionerDetails1 = new PensionerDetail("12904284925403", "Raj", "15-11-1997", "PQWER12345", 80000.00,
				12000.00, "family", bankDetail);
		assertNotNull(pensionerDetails1);
	}

	@Test
	 void PensionerDetailSettersTest() {
		PensionerDetail pensionerDetail1 = new PensionerDetail();
		pensionerDetail1.setAadhaarNumber("1211121324343543");
		pensionerDetail1.setName("Raj");
		pensionerDetail1.setDateOfBirth("15-11-1997");
		pensionerDetail1.setPanNumber("POQWERT12345");
		pensionerDetail1.setSalary(80000.00);
		pensionerDetail1.setAllowance(12000.00);
		pensionerDetail1.setPensionType("family");
		pensionerDetail1.setBankDetail(bankDetail);
		assertNotNull(pensionerDetail1);

	}

}
