package springdemoo.demo;

import org.springframework.stereotype.Component;

@Component

public class Jio implements Sim {

	@Override
	public void calling() {
		System.out.println("Calling via Jio !");
		
	}

}
