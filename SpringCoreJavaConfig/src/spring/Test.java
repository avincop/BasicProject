package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
         ApplicationContext context= new AnnotationConfigApplicationContext(SpringConfig.class);
         Emp emp=(Emp) context.getBean("getEmp");
         emp.emp_id=100;
         emp.emp_name="Avinash";
         emp.EmpInfo();
	}
}
