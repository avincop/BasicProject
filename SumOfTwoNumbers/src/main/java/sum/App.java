package sum;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context=new ClassPathXmlApplicationContext("sum/add.xml");
       Addition add= (Addition) context.getBean("obj1");
       add.sum();
       
       Addition add1= (Addition) context.getBean("obj2");
       add1.sum();
       
       Addition add2= (Addition) context.getBean("obj3");
       add2.sum();
    }
}
