package optional.test;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

public class TestOptionals {

	@Test
	public void test() {
		Optional<String> opt = Optional.ofNullable(null);
		System.out.println(opt);
		
		
	}

}
