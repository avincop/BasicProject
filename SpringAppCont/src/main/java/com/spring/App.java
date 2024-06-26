package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context= new ClassPathXmlApplicationContext("ApplicationContext.xml");
        SimpleClass simple=(SimpleClass) context.getBean("simple");
        simple.show();
    }
}
