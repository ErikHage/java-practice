package com.ehage.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*; 

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.ehage.config.Constants;
import com.ehage.config.SpringRootConfiguration;
import com.ehage.config.SpringWebConfiguration;
import com.ehage.exception.BeerNotFoundException;
import com.ehage.model.Beer;
import com.ehage.service.BeerService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		SpringRootConfiguration.class, 
		SpringWebConfiguration.class})
@WebAppConfiguration
public class TestRestBeerController {

	@InjectMocks
	private RestBeerController controller;

	@Mock
	private BeerService mockBeerService;

	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = standaloneSetup(controller).build();  
	}    

	@Test
	public void testCreateBeer() {
		try {
			Beer beer = getBeer(1);
			String json = getBeerJson(beer);

			when(mockBeerService.add(beer)).thenReturn(beer);

			mockMvc.perform(post("/api/beer/save")
						.contentType(Constants.APPLICATION_JSON)
						.content(json))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(Constants.APPLICATION_JSON))
				.andExpect(jsonPath("id", is(1)))
				.andExpect(jsonPath("style", is("APA")))
				.andExpect(jsonPath("name", is("American Eagle Pale Ale")))
				.andExpect(jsonPath("rating", is(3.5)))
				.andExpect(jsonPath("notes", is("Tasty")));
			
			verify(mockBeerService, times(1)).add(beer);
			verifyNoMoreInteractions(mockBeerService);

		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed due to Exception: " + e.getMessage());
		}
	}	

	@Test
	public void testGetBeerFound() {
		try {
			Beer beer = getBeer(1);

			when(mockBeerService.getOne(1)).thenReturn(beer);

			mockMvc.perform(get("/api/beer/entry/1"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(Constants.APPLICATION_JSON))
				.andExpect(jsonPath("id", is(1)))
				.andExpect(jsonPath("style", is("APA")))
				.andExpect(jsonPath("name", is("American Eagle Pale Ale")))
				.andExpect(jsonPath("rating", is(3.5)))
				.andExpect(jsonPath("notes", is("Tasty")));

			verify(mockBeerService, times(1)).getOne(1);
			verifyNoMoreInteractions(mockBeerService);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed due to Exception: " + e.getMessage());
		}
	}
	
	@Test
	public void testGetBeerNotFound() {
		try {
			when(mockBeerService.getOne(1)).thenThrow(new BeerNotFoundException(1, "Beer 1 not found"));

			mockMvc.perform(get("/api/beer/entry/1"))
				.andDo(print())
				.andExpect(status().isNotFound())
				.andExpect(content().contentType(Constants.APPLICATION_JSON))
				.andExpect(jsonPath("message", is("Beer 1 not found")));

			verify(mockBeerService, times(1)).getOne(1);
			verifyNoMoreInteractions(mockBeerService);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed due to Exception: " + e.getMessage());
		}
	}	
	
	@Test
	public void testGetAllBeersFound() {
		try {
			List<Beer> beers = getBeerList(3);

			when(mockBeerService.getAll()).thenReturn(beers);

			mockMvc.perform(get("/api/beer/entries"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(Constants.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[1].id", is(2)))
				.andExpect(jsonPath("$[2].id", is(3)));

			verify(mockBeerService, times(1)).getAll();
			verifyNoMoreInteractions(mockBeerService);

		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed due to Exception: " + e.getMessage());
		}
	}	
	
	@Test
	public void testUpdateBeer() {
		try {
			Beer beer = getBeer(1);
			String json = getBeerJson(beer);

			when(mockBeerService.update(beer)).thenReturn(beer);

			mockMvc.perform(post("/api/beer/update")
						.contentType(Constants.APPLICATION_JSON)
						.content(json))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(Constants.APPLICATION_JSON))
				.andExpect(jsonPath("id", is(1)))
				.andExpect(jsonPath("style", is("APA")))
				.andExpect(jsonPath("name", is("American Eagle Pale Ale")))
				.andExpect(jsonPath("rating", is(3.5)))
				.andExpect(jsonPath("notes", is("Tasty")));
			
			verify(mockBeerService, times(1)).update(beer);
			verifyNoMoreInteractions(mockBeerService);

		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed due to Exception: " + e.getMessage());
		}
	}	
	
	@Test
	public void testUpdateBeerThrowExceptionNotFound() {
		try {
			Beer beer = getBeer(1);
			String json = getBeerJson(beer);

			when(mockBeerService.update(beer)).thenThrow(new BeerNotFoundException(1,"Beer 1 not found"));

			mockMvc.perform(post("/api/beer/update")
						.contentType(Constants.APPLICATION_JSON)
						.content(json))
				.andDo(print())
				.andExpect(status().isNotFound())
				.andExpect(content().contentType(Constants.APPLICATION_JSON))
				.andExpect(jsonPath("message", is("Beer 1 not found")));
			
			verify(mockBeerService, times(1)).update(beer);
			verifyNoMoreInteractions(mockBeerService);

		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed due to Exception: " + e.getMessage());
		}
	}		
	
	@Test
	public void testDeleteBeer() {
		try {
			mockMvc.perform(delete("/api/beer/delete/1"))
				.andDo(print())
				.andExpect(status().isOk());
			
			verify(mockBeerService, times(1)).deleteById(1);
			verifyNoMoreInteractions(mockBeerService);

		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed due to Exception: " + e.getMessage());
		}
	}	
	
	@Test
	public void testDeleteAllBeers() {
		try {
			mockMvc.perform(delete("/api/beer/delete/all"))
				.andDo(print())
				.andExpect(status().isOk());
			
			verify(mockBeerService, times(1)).deleteAll();
			verifyNoMoreInteractions(mockBeerService);

		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed due to Exception: " + e.getMessage());
		}
	}	
	
	@Test
	public void testDeleteBeerThrowExceptionNotFound() {
		try {
			
			doThrow(new BeerNotFoundException(1,"Beer 1 not found")).when(mockBeerService).deleteById(1);

			mockMvc.perform(delete("/beer/delete/1"))
					.andDo(print())
					.andExpect(status().isNotFound())
					.andExpect(content().contentType(Constants.APPLICATION_JSON))
					.andExpect(jsonPath("message", is("Beer 1 not found")));
			
			verify(mockBeerService, times(1)).deleteById(1);
			verifyNoMoreInteractions(mockBeerService);

		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed due to Exception: " + e.getMessage());
		}
	}		

	private Beer getBeer(long id) {
		Beer beer = new Beer();
		beer.setId(id);
		beer.setName("American Eagle Pale Ale");
		beer.setStyle("APA");
		beer.setRating(3.5);
		beer.setNotes("Tasty");
		return beer;
	}
	
	private List<Beer> getBeerList(int num) {
		List<Beer> beers = new ArrayList<Beer>();
		for(int i=1; i<=num; i++) {
			beers.add(getBeer(i));
		}		
		return beers;
	}

	private String getBeerJson(Beer beer) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(beer);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed due to exception" + e.getMessage());			
		}
		return null;
	}

}
