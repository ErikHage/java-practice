package com.ehage.spring.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CacheTesterImpl implements CacheTester {

	@Cacheable("itemCache")
	public Item getNumber(String s) {
		
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			
		}
		return new Item(new Long(1), s);
	}

}
