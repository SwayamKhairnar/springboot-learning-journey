package com.Dependencies.MyApp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Dextop implements Computer{
    public void compile(){
        System.out.println("Compiled using Dextop!");
    }
}
