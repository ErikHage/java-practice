package com.ehage.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ehage.config.SpringRootConfiguration;
import com.ehage.config.SpringWebConfiguration;
import com.ehage.model.Beer;
import com.ehage.service.BeerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringRootConfiguration.class, 
		SpringWebConfiguration.class})
@WebAppConfiguration
public class TestBeerController {
    
    private MockMvc mockMvc;
    
    @InjectMocks
    private BeerController controller;
    
    @Mock
    private BeerService beerService;
    
    @Before
    public void setup() {  
    	MockitoAnnotations.initMocks(this);
    	this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();    	   	
    }
    
	@Test
	public void testAddBeerForm() {		
		try {
			mockMvc.perform(get("/addBeerForm"))
				.andExpect(view().name("AddBeer"))
				.andExpect(model().attributeExists("beer"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed due to Exception: " + e.getMessage());
		}
	}
	
	@Test
	public void testSaveBeer() {				
		Mockito.when(beerService.getAll()).thenReturn(this.getTestBeerList());		
		try {
			mockMvc.perform(get("/saveBeer"))
				.andExpect(redirectedUrl("/beerList"));			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed due to Exception: " + e.getMessage());
		}
	}
	
	@Test
	public void testBeerList() {	
		Mockito.when(beerService.getAll()).thenReturn(this.getTestBeerList());
		try {
			mockMvc.perform(get("/beerList"))			
				.andExpect(view().name("BeerList"))
				.andExpect(model().attributeExists("beers"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed due to Exception: " + e.getMessage());
		}
	}
	
	private List<Beer> getTestBeerList() {
		List<Beer> testList = new ArrayList<Beer>();
		testList.add(new Beer(1, "American Eagle Pale Ale", "APA", 3.5, "tangy"));
		testList.add(new Beer(2, "American Eagle Pale Ale", "APA", 3.5, "tangy"));
		testList.add(new Beer(3, "American Eagle Pale Ale", "APA", 3.5, "tangy"));	
		return testList;
	}
	
	/* form params

	 				.param("id", "")
					.param("style", "APA")
					.param("volume", "12.0")
					.param("ibu", "45.1")
					.param("srm", "45.5")
					.param("notes", "Tangy")

	 */

}
