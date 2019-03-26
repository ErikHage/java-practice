package com.ehage.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ehage.exception.BeerNotFoundException;
import com.ehage.model.Beer;
import com.ehage.service.BeerService;

@Controller
public class BeerController {

	private static final Log logger = LogFactory.getLog(BeerController.class);
	
	@Autowired
	private BeerService beerService;

	@RequestMapping(value="/")
	public String home() {
		return "Home";
	}
	
	@RequestMapping("/addBeerForm")
	public String addBeer(Model model) {
		logger.info("endpoint: /addBeerForm");
		model.addAttribute("beer", new Beer());
		return "AddBeer";
	}
	
	@RequestMapping(value="/saveBeer")
	public String saveBeer(@Valid @ModelAttribute Beer beer, 
			BindingResult bindingResult, Model model)	{		
		logger.info("endpoint: /saveBeer");
		
		if(bindingResult.hasErrors()) {
			FieldError fieldError = bindingResult.getFieldError();
			logger.error("Code: " + fieldError.getCode() + ", field: " + fieldError.getField());
			return "AddBeer";
		}
		
		beerService.add(beer);
		return "redirect:/beerList";
	}
	
	@RequestMapping(value="/beerList")
	public String listBeers(Model model) {
		logger.info("endpoint: /beerList");
		List<Beer> beers = beerService.getAll();	
		model.addAttribute("beers", beers);
		return "BeerList";
	}
	
	@RequestMapping(value="/displayBeer/{beerId}")
	public String displayBeerById(@PathVariable long beerId, Model model) {
		logger.info("endpoint: /displayBeer/" + beerId);
		
		if(!model.containsAttribute("beer")) {
			Beer beer = beerService.getOne(beerId); 
			model.addAttribute("beer", beer);
		}
		
		return "DisplayBeer";
	}
	
	@RequestMapping(value="/updateBeer") 
	public String updateBeer(@Valid @ModelAttribute Beer beer,
			BindingResult bindingResult,
			RedirectAttributes model) {
		logger.info("endpoint: /updateBeer");
		
		model.addAttribute("beerId", beer.getId());
		model.addFlashAttribute("beer", beer);
		
		if(bindingResult.hasErrors()) {
			FieldError fieldError = bindingResult.getFieldError();
			logger.error("Code: " + fieldError.getCode() + ", field: " + fieldError.getField());
			return "DisplayBeer";
		}
		
		beerService.update(beer);			
		model.addFlashAttribute("isUpdateSuccessful", "T");
		
		return "redirect: displayBeer/{beerId}";
	}
	
	@RequestMapping(value="/testException")
	public String testException() {
		throw new BeerNotFoundException(1, "Beer not found");
	}

}
