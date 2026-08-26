package com.swayam.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DiApplicationTests {

    @Autowired
    private Dev dev;

    @Test
    void contextLoads() {
        assertNotNull(dev);
        dev.build();
    }

}
