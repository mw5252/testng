package com.kakaopay.sample;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDependsOnMethodsExample {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod() 각 테스트 메소드 전에 항상 실행된다.");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod()\n 각 테스트 메소드 후에 항상 실행된다.");
    }

    @Test
    public void testAdd() {
        System.out.println("testAdd()");
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.add(15, 2), 17);
    }

    @Test
    public void testDivide() {
        System.out.println("testDivide()");
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(16, 0), 16);
    }

//    testProcessRealNumbers 는 testAdd과 testDivide 의 종속성을 갖기에, 2건이 Pass 여야 진행된다.
    @Test(dependsOnMethods = {"testAdd", "testDivide"})
    public void testProcessRealNumbers() {
        System.out.println("testProcessRealNumbers() testAdd과 testDivide 의 종속성을 갖기에, 2건이 Pass 여야 진행된다.");
    }

    //    testProcessRealNumbers 는 testAdd과 testDivide 의 종속성을 갖지만, alwaysRun=true 되어 있어 결과에 무관하게 항상 실행된다.
    @Test(dependsOnMethods = {"testAdd", "testDivide"}, alwaysRun = true)
    public void testProcessEvenNumbers() {
        System.out.println("testProcessEvenNumbers()\n testAdd과 testDivide 의 종속성을 갖지만, alwaysRun=true 되어 있어 결과에 무관하게 항상 실행된다. ");
    }
}
