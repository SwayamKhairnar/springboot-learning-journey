package com.swayam.springxml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

public class AppTest {

    @Test
    public void testBeanCreationAndInjection() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Dev dev = (Dev) context.getBean("dev");
        assertNotNull(dev);
        assertNotNull(dev.getComp());
        dev.build();
    }
}
