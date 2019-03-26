package com.ehage.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ehage.config.Constants;
import com.ehage.exception.BeerNotFoundException;
import com.ehage.model.Beer;
import com.ehage.model.RestMessage;
import com.ehage.service.BeerService;

@RestController
@RequestMapping(value="/api/beer")
public class RestBeerController {

	private static final Log logger = LogFactory.getLog(RestBeerController.class);
	
	@Autowired
	private BeerService beerService;

	@RequestMapping(value="/entry/{id}",
			produces=Constants.APPLICATION_JSON,
			method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Beer getBeer(@PathVariable long id) {
		logger.debug("endpoint: .../entry/" + id);
		Beer beer = beerService.getOne(id);
		return beer;
	}
	
	@RequestMapping(value="/entries",
			produces=Constants.APPLICATION_JSON,
			method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Beer> getAllBeers() {
		logger.debug("endpoint: .../entries");
		return beerService.getAll();
	}

	@RequestMapping(value="/save",
			consumes=Constants.APPLICATION_JSON,
			produces=Constants.APPLICATION_JSON,
			method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public Beer createBeer(@RequestBody Beer beer) {
		logger.debug("endpoint: .../save with payload: " + beer.toString());
		return beerService.add(beer);
	}
	
	@RequestMapping(value="/update",
			consumes=Constants.APPLICATION_JSON,
			produces=Constants.APPLICATION_JSON,
			method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public Beer updateBeer(@RequestBody Beer beer) {
		logger.debug("endpoint: .../update with payload: " + beer.toString());
		return beerService.update(beer);
	}

	@RequestMapping(value="/delete/{id}",
			method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteBeer(@PathVariable long id) {
		logger.debug("endpoint: .../delete/" + id);
		beerService.deleteById(id);
	}
	
	@RequestMapping(value="/delete/all",
			method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteBeer() {
		logger.debug("endpoint: .../delete/all");
		beerService.deleteAll();
	}
	
	@ExceptionHandler(BeerNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody RestMessage handleBeerNotFound(BeerNotFoundException e) {
		return new RestMessage(e.getMessage());
	}

}
