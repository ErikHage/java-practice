package concert;

import org.springframework.stereotype.Component;

@Component
public class Movie implements Performance {
	
	@Override
	public void perform() throws Exception {
		System.out.println("The show is starting...");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		
		System.out.println("The show is over.");
		
		if(Math.random()*2 > 1) {
			throw new Exception("");
		}	

	}

}
