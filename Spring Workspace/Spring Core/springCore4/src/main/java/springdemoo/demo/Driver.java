package springdemoo.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

//		Mobile mobile = (Mobile) context.getBean("mobile");
//		mobile.call();
		
		Mobile mobile1 = context.getBean(Mobile.class);
		System.out.println(mobile1);

		Mobile mobile2 = context.getBean(Mobile.class);
		System.out.println(mobile2);
		
	}
}


// Topic cover in this example
// @primary
// @qualifier
// @scope("prototype")
// @Bean