package com.cognizant.model.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.model.BankDetail;
import com.cognizant.model.PensionerInput;

@SpringBootTest
 class PensionerInputTest {

	PensionerInput pensionerInput = new PensionerInput();

	@Test
	 void PensionerDetailBeanTest() {
		assertNotNull(pensionerInput);
	}

	@Test
	 void PensionerInputNoArgConstructorTest() {
		PensionerInput pensionerInput1 = new PensionerInput();
		assertThat(pensionerInput1).isNotNull();
	}

	@Test
	 void PensionerInputAllArgConstructorTest() {
		PensionerInput pensionerInput1 = new PensionerInput("Pratyush", "06-11-1999", "PQWER12345", "1234567654678",
				"family");
		assertNotNull(pensionerInput1);
	}

	@Test
	 void PensionerDetailSettersTest() {
		PensionerInput pensionerDetail1 = new PensionerInput();
		pensionerDetail1.setAadhaarNumber("1211121324343543");
		pensionerDetail1.setName("Pratyush");
		pensionerDetail1.setDateOfBirth("06-11-1999");
		pensionerDetail1.setPanNumber("POQWERT12345");
		pensionerDetail1.setPensionType("family");
		assertNotNull(pensionerDetail1);

	}

}
