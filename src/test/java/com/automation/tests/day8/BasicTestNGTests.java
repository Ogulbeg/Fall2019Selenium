package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTestNGTests {
    @Test
    public  void test1() {
        String expected = "apple";
        String actual ="apple";
        Assert.assertEquals(expected,actual);
    }
    @Test//(description = "Verify if method can reverse a string")
    public void test2(){
       int num1 =5;
       int num2 =10;

       // it calls hard Assertion.
        // if assertion fails = it stops the execution (due to exception).
        Assert.assertTrue(num1>num2);

    }
}
