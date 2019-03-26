package lambdas;

import java.util.List;

public class Lambdas {

	public boolean printList(List<? extends Object> list) {				
		list.forEach(e -> System.out.println(e));		
		return true;
	}
	
	public boolean doublePrintList(List<? extends Object> list) {		
		list.forEach(e -> {
			System.out.println(e);
			System.out.println(e);
		});		
		return true;
	}
	
	public boolean printListWithSeparator(List<String> list, String separator) {
		list.forEach((String e) -> {			
			System.out.print(e + separator);
		});		
		System.out.println();
		return true;
	}
	
	
}
