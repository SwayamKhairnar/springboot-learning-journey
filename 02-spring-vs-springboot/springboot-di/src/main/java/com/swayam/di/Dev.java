package com.swayam.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {

    // Demonstrating Dependency Injection using @Autowired and @Qualifier
    // Desktop is annotated with @Primary, but @Qualifier("laptop") explicitly overrides it.
    private final Computer computer;

    @Autowired
    public Dev(@Qualifier("laptop") Computer computer) {
        this.computer = computer;
    }

    public void build() {
        System.out.println("Dev is building the application...");
        computer.compile();
    }
}
