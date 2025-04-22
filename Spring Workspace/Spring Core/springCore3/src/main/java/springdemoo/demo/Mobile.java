package springdemoo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mobile {
	
	@Value("Vivo")
	private String name;
	
	@Autowired
	@Qualifier("jio")
	private Sim sim;
	
	public void call() {
		sim.calling();
	}

	public void display() {
		System.out.println(name);
	}

}
