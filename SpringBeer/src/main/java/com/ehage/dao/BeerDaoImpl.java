package com.ehage.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.ehage.controller.BeerController;
import com.ehage.exception.BeerNotFoundException;
import com.ehage.model.Beer;

@Repository("beerRepository")
public class BeerDaoImpl implements BeerDao {

	private static final Log logger = LogFactory.getLog(BeerDaoImpl.class);

	private static final Map<Long,Beer> beerMap = new HashMap<Long,Beer>();;
	private static final AtomicLong idSeq = new AtomicLong(1);

	static {
		beerMap.put(777L, new Beer(777,"Samuel Adams Boston Lager","American Lager",5,"Delicious"));
	}
	
	public Beer create(Beer beer) {
		beer.setId(idSeq.getAndIncrement());
		logger.debug("Creating beer: " + beer.toString());
		beerMap.put(beer.getId(),beer);
		return beerMap.get(beer.getId());
	}

	public List<Beer> read() {
		logger.debug("Reading all beers");
		return new ArrayList<Beer>(beerMap.values());
	}

	public Beer update(Beer beer) {
		logger.debug("Updating beer: " + beer.toString());
		if(beerMap.containsKey(beer.getId())) {
			beerMap.put(beer.getId(), beer);
		} else {
			throw new BeerNotFoundException(beer.getId(), "No beer with id = " + beer.getId() + " exists");
		}
		return beer;
	}

	public void delete(Beer beer) {
		logger.debug("Deleting beer: " + beer.toString());
		if(beerMap.containsKey(beer.getId())) {
			beerMap.remove(beer.getId());
		} else {		
			throw new BeerNotFoundException(beer.getId(), "No beer with id = " + beer.getId() + " exists");
		}
	}

	public Beer readById(Long id) {
		logger.debug("Reading beer with id = " + id);
		if(beerMap.containsKey(id)) {
			return beerMap.get(id);
		}		
		throw new BeerNotFoundException(id, "No beer with id = " + id + " exists");
	}
	
	public void deleteAll() {
		beerMap.clear();
		idSeq.set(1);
	}

}
