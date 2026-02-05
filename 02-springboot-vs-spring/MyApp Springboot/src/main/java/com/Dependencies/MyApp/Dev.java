package com.Dependencies.MyApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {

    //this is field injection
    @Autowired
    @Qualifier("laptop")
    private Computer computer;


    //this is constructor injection
//    public Dev(Laptop laptop){
//        this.laptop=laptop;
//    }

    public void build(){
        System.out.println("Building Something");
        computer.compile();
    }
}
//Here we use the DI(dependencies injection) i.e the inversion of control
//with its helpo we were able to Automatically make an object of The dev class without directly doing it
//DI also helps in for the we use AplicationCOntext we made its obj which stores the obj returend by Aplication when runned
//Then to make the obj we also make our Dev class as component



//Now we want to make sure that We can derive this at multiple layers of inheritance not just from DEV to Application
