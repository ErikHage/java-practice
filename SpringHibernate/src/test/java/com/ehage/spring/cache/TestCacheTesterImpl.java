package com.ehage.spring.cache;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ehage.spring.configuration.HibernateConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={HibernateConfig.class})
public class TestCacheTesterImpl {

	@Autowired
	private CacheTester tester;
	
	@Test
	public void test() {
		int time = DateTime.now().getSecondOfDay();
		
		printDuration(time);
		tester.getNumber("one");
		printDuration(time);
		tester.getNumber("one");
		printDuration(time);
		tester.getNumber("one");
		printDuration(time);
		
	}
	
	private void printDuration(int start) {
		System.out.println("Duration:" + (DateTime.now().getSecondOfDay() - start));
	}

}
