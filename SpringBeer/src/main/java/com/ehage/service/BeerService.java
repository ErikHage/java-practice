package com.ehage.service;

import java.util.List;

import com.ehage.model.Beer;

public interface BeerService {

	public Beer add(Beer beer);
	public List<Beer> getAll();
	public Beer getOne(long id);
	public Beer update(Beer beer);
	public void delete(Beer beer);
	public void deleteById(long id);
	public void deleteAll();
	
}
