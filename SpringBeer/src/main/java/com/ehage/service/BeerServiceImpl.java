package com.ehage.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehage.dao.BeerDao;
import com.ehage.model.Beer;

@Service("beerService")
public class BeerServiceImpl implements BeerService {

	private static final Log logger = LogFactory.getLog(BeerServiceImpl.class);
	
	@Autowired
	private BeerDao beerDao;
	
	public BeerServiceImpl() {		
	}	
	
	public Beer add(Beer beer) {	
		logger.debug("In add(beer) : param = " + beer.toString());
		return beerDao.create(beer);		
	}

	public List<Beer> getAll() {
		logger.debug("In getAll()");
		return beerDao.read();
	}
	
	public Beer getOne(long id) {
		logger.debug("In getOne(id) : param = " + id);
		return beerDao.readById(id);
	}

	public Beer update(Beer beer) {
		logger.debug("In update(beer) : param = " + beer.toString());
		return beerDao.update(beer);
	}

	public void delete(Beer beer) {
		logger.debug("In delete(beer) : param = " + beer.toString());
		beerDao.delete(beer);
	}
	
	public void deleteById(long id) {
		logger.debug("In deletById(id) : param = " + id);
		Beer beer = new Beer();
		beer.setId(id);
		beerDao.delete(beer);
	}
	
	public void deleteAll() {
		logger.debug("In deleteAll()");
		beerDao.deleteAll();
	}

}
