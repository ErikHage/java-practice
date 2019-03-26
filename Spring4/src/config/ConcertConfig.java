package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import concert.Audience;
import concert.EncoreableIntroducer;
import concert.Movie;
import concert.Performance;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class ConcertConfig {
	
	@Bean
	public Performance movie() {
		return new Movie();
	}
	
	@Bean
	public Audience audience() {
		return new Audience();
	}
	
	@Bean
	public EncoreableIntroducer encoreableIntroducer() {
		return new EncoreableIntroducer();
	}

}
