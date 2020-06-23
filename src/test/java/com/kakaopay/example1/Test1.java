package com.kakaopay.example1;

import org.testng.annotations.Test;

public class Test1 {
    @Test(groups = { "functest", "checkintest" })
    public void testMethod1() {
        System.out.println("testMethod1 test");
    }

    @Test(groups = {"functest", "checkintest"} )
    public void testMethod2() {
        System.out.println("testMethod2 test");
    }

    @Test(groups = { "functest" })
    public void testMethod3() {
        System.out.println("testMethod3 test");
    }
}

