package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateAccountTests extends PhoneBookTestBase {
    @Test

    public void newUserRegistrationPositiveTest(){
        // click on Login link
        driver.findElement(By.cssSelector("[href='/login']")).click();
        //enter Email
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("sopranom@gmail.com");
        //Enter Password
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("A1320$ak");
        //click on Registration button
        driver.findElement(By.name("registration")).click();
        //verify SingOut is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));


    }










}
