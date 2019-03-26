package lambdas.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lambdas.Lambdas;

import org.junit.Test;

public class TestLambdas {

	private void printTest(String s) {
		System.out.println("Running Test: " + s);
	}
	
	@Test
	public void testPrintList() {
		
		printTest("testPrintList");
		
		Lambdas lambdas = new Lambdas();
		List<String> list = new ArrayList<String>();
		
		list = Arrays.asList("a","b","c","d");		
		
		assertTrue(lambdas.printList(list));		
	}
	
	@Test
	public void testDoublePrintList() {
		
		printTest("testDoublePrintList");
		
		Lambdas lambdas = new Lambdas();
		List<String> list = new ArrayList<String>();
		
		list = Arrays.asList("a","b","c","d");		
		
		assertTrue(lambdas.doublePrintList(list));		
	}

	@Test
	public void testPrintListWithSeparator() {
		
		printTest("testPrintListWithSeparator");
		
		Lambdas lambdas = new Lambdas();
		List<String> list = new ArrayList<String>();
		
		list = Arrays.asList("a","b","c","d");		
		
		assertTrue(lambdas.printListWithSeparator(list, ","));		
	}
	
}
