package com.swayam.springxml;

public class Desktop implements Computer {

    public Desktop() {
        System.out.println("Desktop bean instantiated");
    }

    @Override
    public void compile() {
        System.out.println("Compiling on Desktop...");
    }
}
