package com.ehage.dao;

import java.util.List;

import com.ehage.model.Beer;

public interface BeerDao {

	public Beer create(Beer beer);
	public List<Beer> read();
	public Beer readById(Long id);
	public Beer update(Beer beer);
	public void delete(Beer beer);
	public void deleteAll();
	
}
