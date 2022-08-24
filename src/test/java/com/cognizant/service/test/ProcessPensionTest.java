package com.cognizant.service.test;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.model.BankDetail;
import com.cognizant.model.PensionDetail;
import com.cognizant.model.PensionerDetail;
import com.cognizant.model.PensionerInput;
import com.cognizant.repository.PensionDetailRepository;

@SpringBootTest(classes = ProcessPensionTest.class)
@AutoConfigureMockMvc
public class ProcessPensionTest {
	@Mock
	private PensionDetailRepository pensionDetailRepository;

	PensionDetail pd=new PensionDetail(50000,500);
	@Test
	void testSavePensionDetail(PensionDetail pensionDetail) {
		pensionDetailRepository.save(pensionDetail);
		assertNotNull(pd);
	}
	
}
