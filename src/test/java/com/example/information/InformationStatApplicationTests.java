package com.example.information;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.information.controller.InfoController;
import com.example.information.dto.InfoDTO;
import com.example.information.entity.Info;
import com.example.information.repository.InfoRepository;

@SpringBootTest
class InformationStatApplicationTests {

	@Autowired
	@Mock
	private InfoRepository inforepository;
	
	@InjectMocks
	InfoController controller;
	
	
	
	@Test
	void contextLoads() {
	}

	@Test
	public void infoTest() {
	Info info = new Info();
	info.setId(1);
	info.setAddress("10950 Jeff St");
	info.setEmail("harris@gmail.com");
	info.setName("Delery Harrison");
	inforepository.save(info);
	Info SavedInfo = inforepository.findById(1L).get();
	assertNotNull(SavedInfo);
	}
	@Test
	public void FindAddress() {
		Info info = new Info();
		info.setAddress("1095 Copeland Dr");
		assertNotNull("1095 Copeland Dr",info.getAddress());
		assertEquals("1095 Copeland Dr",info.getAddress());
	}
	
	@Test
	void testRegisterInfo() {
		Info info = new Info();
		info.setId(2);
		info.setAddress("322 Holt St");
		info.setName("Kame Jogn");
		info.setEmail("Kame@yahoo.com");
		Info savedInfo = inforepository.save(info);
		assertNotNull(savedInfo);
		assertEquals(2,savedInfo.getId());
	}
	@Test
	void testName() {
		Info info = new Info();
		info.setName("Dee");
		assertNotNull("DELERY", info.getName());
		assertEquals("Dee", info.getName());
	}
	@Test
	void testRegisterAccount() {
        Info info = new Info();
		
		info.setId(1);
		info.setAddress("322 Holt St");
		info.setName("Kame Jogn");
		info.setEmail("Kame@yahoo.com");
		Info savedInfo = inforepository.save(info);
		//when(inforepository.save(info)).thenReturn(savedInfo);
		//Info outputInfoAccount = controller.getInfoById();
		assertEquals(1,savedInfo.getId());
		assertNotNull("Derek", savedInfo.getName());
		assertNotNull(savedInfo);
		
	}
	@Test
	public void addResponseTest() {
		ResponseEntity response = con
	}
}
