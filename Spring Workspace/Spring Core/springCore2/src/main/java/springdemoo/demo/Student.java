package springdemoo.demo;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private int id = 102;
	private String name = "Rahul Patel";

	public void display() {
		System.out.println(id + " -> " + name);
	}

}
