package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends PhoneBookTestBase{
    @Test
    public void loginPositiveTest(){
        // click on Login link
        click(By.cssSelector("[href='/login']"));
        //enter Email
        type(By.name("email"), "sopranom@gmail.com");
        //Enter Password
        type(By.name("password"), "A1320$ak");
        // click on login button
        click(By.name("login"));
        //verify SingOut is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));

    }

}
