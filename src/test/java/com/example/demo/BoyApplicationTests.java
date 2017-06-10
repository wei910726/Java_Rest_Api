package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
@Transactional()
public class BoyApplicationTests {
	private MockMvc MockMvc;
	
	@Autowired
    protected WebApplicationContext wac;
	

	
	@Before()
	public void Setup() throws Exception{
		MockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testBoyList()throws Exception {
        MockMvc.perform(get("/boys")
        	.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
			.andExpect(status().isOk());
	}
	
	@Test
	public void testBoyAdd() throws Exception{
		MockMvc.perform(post("/boys?age=17&name=gab"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.age").value(17))
			.andExpect(jsonPath("$.name").value("gab")); 
	}
	
	@Test
	public void testBoyUpdate() throws Exception{
		MockMvc.perform(put("/boys/2?age=11&name=tim"))
		    .andExpect(status().isOk())
		    .andExpect(jsonPath("$.age").value(11))
		    .andExpect(jsonPath("$.name").value("tim"));
	}
	
	@Test
	public void testBoyDel() throws Exception{
		MockMvc.perform(delete("/boys/2"))
	    .andExpect(status().isOk());
	}

}
