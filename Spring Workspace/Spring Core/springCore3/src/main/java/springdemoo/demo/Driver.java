package springdemoo.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

//		Mobile mobile = (Mobile) context.getBean("mobile");
//		mobile.call();
		
		Mobile mobile = context.getBean(Mobile.class);
		mobile.call();
		mobile.display();
	}
}


// Topic cover in this example
// @primary
// @qualifier
// @scope("prototype")
// @Bean