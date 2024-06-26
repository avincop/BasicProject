package setter.refrence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("setter/refrence/student.xml");
//        Student st= context.getBean("obj_student",Student.class);
//        System.out.println(st.getRollNo());
//        System.out.println(st.getName());
//        System.out.println(st.getDept().getSubject());
//        System.out.println(st.getDept().getStream());
//        System.out.println(st.getFees().getFees());
        System.out.println("----------------");
        
        Student st1= context.getBean("obj_std",Student.class);
        System.out.println(st1.getRollNo());
        System.out.println(st1.getName());
        System.out.println(st1.getDept().getSubject());
        System.out.println(st1.getDept().getStream());
        System.out.println(st1.getFees().getFees());
        System.out.println("----------------");
    }
}
