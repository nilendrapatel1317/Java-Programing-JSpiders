package springdemoo.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Primary 
//@Scope("prototype") // to make multiple instance
public class Airtal implements Sim {

	@Override
	public void calling() {
		System.out.println("Calling via Airtel !");

	}

}
