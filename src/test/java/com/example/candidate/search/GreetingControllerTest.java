package com.example.candidate.search;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testDefaultGreeting() throws Exception {
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/greeting").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        assertTrue(content.contains("Hello, World!"));
    }
    
	@Test
	public void testCustomGreeting() throws Exception {
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/greeting?name=Max").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        assertTrue(content.contains("Hello, Max!"));
    }
}
