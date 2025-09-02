package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends PhoneBookTestBase{
    @Test
    public void loginPositiveTest(){
        clickOnLoginLink();
        fillRegisterForm(new User().setEmail("sopranom@gmail.com").setPassword("A1320$ak"));
        clickOnLoginButton();
        Assert.assertTrue(isSignOutPresent());

    }

    @Test
    public void loginNegativeWitouthEmailTest(){
        clickOnLoginLink();
        fillRegisterForm(new User().setPassword("A1320$ak"));
        clickOnLoginButton();
        Assert.assertTrue(isAlertDisplayed());

    }


}
