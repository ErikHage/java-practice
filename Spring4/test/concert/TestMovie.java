package concert;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.ConcertConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConcertConfig.class})
public class TestMovie {

	@Autowired
	private Performance movie;
	
	@Test
	public void test() throws Exception {		
		try {
			movie.perform();
			((Encoreable) movie).performEncore();
		} catch(Exception e) {
			fail();
		}
		
	}

}
