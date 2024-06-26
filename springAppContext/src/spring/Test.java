package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EmpInfo emp=(EmpInfo)context.getBean("emp");
		emp.emp_id=100;
		emp.emp_name="Avinash";
		emp.showInfo();
		

	}

}
