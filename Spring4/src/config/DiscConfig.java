package config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import soundsystem.BlankDisc;
import soundsystem.CompactDisc;
import soundsystem.TrackCounter;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses={CompactDisc.class})
public class DiscConfig {
	
	@Bean
	public CompactDisc compactDisc() {
		BlankDisc disc = new BlankDisc();
		disc.setTitle("Iron Maiden");
		disc.setArtist("Iron Maiden");
		disc.setTracks(Arrays.asList("Sanctuary","Iron Maiden",
				"Running Free","Phantom of the Opera"));
		return disc;
	}
	
	@Bean TrackCounter trackCounter() {
		return new TrackCounter();
	}
	
}
