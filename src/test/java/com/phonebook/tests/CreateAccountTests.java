package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateAccountTests extends PhoneBookTestBase {
    @Test(enabled = false)

    public void newUserRegistrationPositiveTest() {
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        // click on Login link
        click(By.cssSelector("[href='/login']"));
        //enter Email
        type(By.name("email"), "sopranom"+i+"@gmail.com");
        //Enter Password
        type(By.name("password"), "A1320$ak");
        //click on Registration button
        click(By.name("registration"));
        //verify SingOut is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));

    }

    @Test
    public void exsistedUserRegistrationNegativeTest() {
        // click on Login link
        click(By.cssSelector("[href='/login']"));
        //enter Email
        type(By.name("email"), "sopranom@gmail.com");
        //Enter Password
        type(By.name("password"), "A1320$ak");
        //click on Registration button
        click(By.name("registration"));
        //verify Alert displayed
        Assert.assertTrue(isAlertDisplayed());

    }

}

