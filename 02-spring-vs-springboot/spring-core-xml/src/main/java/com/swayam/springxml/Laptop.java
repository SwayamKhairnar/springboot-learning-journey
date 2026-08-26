package com.swayam.springxml;

public class Laptop implements Computer {

    public Laptop() {
        System.out.println("Laptop bean instantiated");
    }

    @Override
    public void compile() {
        System.out.println("Compiling on Laptop...");
    }
}
