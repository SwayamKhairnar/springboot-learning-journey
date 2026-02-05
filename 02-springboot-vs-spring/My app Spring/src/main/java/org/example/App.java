package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    App(){
        System.out.println("App called!");
    }
    Laptop lap;



    public static void main(String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        dev d=(dev) context.getBean("dev");

        d.build();

//        d.setAge(10);
//        System.out.println(d.getAge());
    }
}
