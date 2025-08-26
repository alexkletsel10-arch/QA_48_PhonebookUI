package com.homework.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateAccountTest extends TestBase {
    @Test
    public void newUserRegistrationPositiveTest(){
        //click on Register link
        driver.findElement(By.cssSelector(".ico-register")).click();
        //Select gender radio button
        driver.findElement(By.cssSelector("#gender-male")).click();
        //driver.findElement(By.cssSelector("#gender-male")).clear();
        //Enter first name
        driver.findElement(By.cssSelector("#FirstName")).click();
        driver.findElement(By.cssSelector("#FirstName")).clear();
        driver.findElement(By.cssSelector("#FirstName")).sendKeys("Aaron");
        //Enter lastname
        driver.findElement(By.cssSelector("[name='LastName']")).click();
        driver.findElement(By.cssSelector("[name='LastName']")).clear();
        driver.findElement(By.cssSelector("[name='LastName']")).sendKeys("Kennedy");
        //Enter Email
        driver.findElement(By.cssSelector("#Email")).click();
        driver.findElement(By.cssSelector("#Email")).clear();
        driver.findElement(By.cssSelector("#Email")).sendKeys("aaron18@gmail.com");
        //Enter Password
        driver.findElement(By.cssSelector("#Password")).click();
        driver.findElement(By.cssSelector("#Password")).clear();
        driver.findElement(By.cssSelector("#Password")).sendKeys("Cadi26$lac");
        //Enter Confirm password
        driver.findElement(By.cssSelector("#ConfirmPassword")).click();
        driver.findElement(By.cssSelector("#ConfirmPassword")).clear();
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("Cadi26$lac");
        // Click on register button
        driver.findElement(By.cssSelector(".button-1.register-next-step-button")).click();
        //verify LogOut link is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//a[text()='Log out']")));
        //verify Continue button is displayed
        Assert.assertTrue(isElementPresent(By.cssSelector("input[value='Continue']")));




    }


}
