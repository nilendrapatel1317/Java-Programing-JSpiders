package springdemoo.demo;

import org.springframework.stereotype.Component;

@Component
public class Person {
	private int id = 101;
	private String name = "Nilendra Patel";

	public void display() {
		System.out.println(id + " -> " + name);
	}

}
