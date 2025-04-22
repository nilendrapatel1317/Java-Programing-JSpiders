package springdemoo.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
	public static void main(String[] args) {
		ApplicationContext context =  new AnnotationConfigApplicationContext(MyConfig.class);
				
		Person person = (Person) context.getBean("person");
		person.display();

		Student student = (Student) context.getBean("student");
		student.display();
	}
}

// Topic cover in this example
// Multiple pojo classes
 