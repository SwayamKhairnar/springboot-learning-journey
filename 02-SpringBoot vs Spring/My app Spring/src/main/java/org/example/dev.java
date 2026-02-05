package org.example;

import org.springframework.context.annotation.Primary;

public class dev {

    Computer comp;
    dev(){
        System.out.println("Default Developer called!");

    }
    public Computer getComp() {
        return comp;
    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }

    public void build(){
        System.out.println("Built with minimal errors!!");
//        System.out.println(age);
        comp.compile();
    }
}
