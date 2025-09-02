package com.homework.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginPositiveTest() {
        //click on Login link
        clickOnLoginLink();
        //Enter Email
        fillLoginForm(new User().setEmail("aaron18@gmail.com").setPassword("Cadi26$lac"));
        // click on Login button
        clickOnLoginButton();
        //verify Logout Button is displayed
        Assert.assertTrue(isLogOutButtonPresent());


    }

    @Test(enabled = false)
    public void loginNegativeWithoutEmailTest() {
        //click on Login link
        clickOnLoginLink();
        //Enter Email
        fillLoginForm(new User().setPassword("Cadi26$lac"));
        // click on Login button
        clickOnLoginButton();
        //verify Logout Button is displayed



    }



    }



