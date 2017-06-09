package com.example.demo;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;




@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional(rollbackForClassName="BoyController.class")
public class BoyApplicationTests {
	private MockMvc MockMvc;
	
	@Autowired
    protected WebApplicationContext wac;

	@Autowired
	private BoyController boyController;
	
	@Before()
	public void Setup() throws Exception{
		MockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testBoySearch(){
		boy boy1 = boyController.boySearch(2);
		int age = boy1.getAge();
		String name = boy1.getName();
		assertEquals(16,age);
		assertEquals("BB", name);
	}
	
	@Test
	public void testBoyAdd(){
		boyController.boyAdd(17, "CC");
		boy real = boyController.boySearch(3);
		String name = real.getName();
		int age = real.getAge();
		assertEquals(17,age);
		assertEquals("CC", name);
	} 
	
	@Test
	public void testBoyDel(){
		boyController.boyDelete(3);
		assertNull(boyController.boySearch(3));
	}
	
	@Test
	public void testBoyList(){
		try {
			MockMvc.perform(get("/boys").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
			.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
