package cm.start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("cm/start/Beans.xml");

		StartApp obj = (StartApp) context.getBean("startApp");

		obj.getMessage();
	}
}
