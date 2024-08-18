import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aurionpro.model.Computer;
import com.aurionpro.model.Hardisk;

public class ComputerTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Hardisk disk = (Hardisk) context.getBean("hardisk", "Hardisk.class");
		System.out.println(disk);
		
		Computer computer = (Computer) context.getBean("computer", "Computer.class");
		System.out.println(computer);

	}

}
