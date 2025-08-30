package com.homework.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateAccountTest extends TestBase {
    @Test
    public void newUserRegistrationPositiveTest() {
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        //click on Register link
        click(By.cssSelector(".ico-register"));
        //Select gender radio button
        click(By.cssSelector("#gender-male"));
        //driver.findElement(By.cssSelector("#gender-male")).clear();
        //findElement(By.cssSelector("#gender-female")).click()
        //Enter first name
        type(By.cssSelector("#FirstName"), "Aaron");
        //Enter lastname
        type(By.cssSelector("[name='LastName']"), "Kennedy");
        //Enter Email
        type(By.cssSelector("#Email"), "aaron18"+i+"@gmail.com");
        //Enter Password
        type(By.cssSelector("#Password"), "Cadi26$lac");
        //Enter Confirm password
        type(By.cssSelector("#ConfirmPassword"), "Cadi26$lac");
        // Click on register button
        click(By.cssSelector(".button-1.register-next-step-button"));
        //verify LogOut link is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//a[text()='Log out']")));
        //verify Continue button is displayed
        Assert.assertTrue(isElementPresent(By.cssSelector("input[value='Continue']")));


    }


}


