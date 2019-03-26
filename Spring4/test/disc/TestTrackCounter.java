package disc;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import soundsystem.CompactDisc;
import soundsystem.TrackCounter;
import config.DiscConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DiscConfig.class})
public class TestTrackCounter {

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog(); 
	
	@Autowired
	private CompactDisc cd;
	
	@Autowired
	private TrackCounter counter;
	
	@Test
	public void test() {
		cd.playTrack(1);
		cd.playTrack(1);
		cd.playTrack(1);
		cd.playTrack(2);
		cd.playTrack(2);
		cd.playTrack(3);
		
		assertEquals(3, counter.getPlayCount(1));
		assertEquals(2, counter.getPlayCount(2));
		assertEquals(1, counter.getPlayCount(3));
		assertEquals(0, counter.getPlayCount(4));
	}
	
}
