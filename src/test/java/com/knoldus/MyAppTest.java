package com.knoldus;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//@Ignore
public class MyAppTest {
    
    private static Addition addition;
    @BeforeClass
    public static void setUp() {
        addition = new Addition();
    }
    
   // @Ignore
    @Test
    public void testAdd() {
        int actualResult = addition.add(2,6);
    int expectedResult = 8;
    assertEquals("Hiii", expectedResult, actualResult);
    }
    
    @AfterClass
    public static void tearDown() {
    
    }
}
