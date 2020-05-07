package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoApplicationTest {

    DemoApplication demoApplication;

    @BeforeEach
    void setUp() {
        demoApplication = new DemoApplication();
    }

    @Test
    void add() {
        assertEquals(demoApplication.add(2,2), 5);
    }
}