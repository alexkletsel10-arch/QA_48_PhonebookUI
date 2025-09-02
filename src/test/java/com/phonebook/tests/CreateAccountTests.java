package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateAccountTests extends PhoneBookTestBase {
    @Test(enabled = false)

    public void newUserRegistrationPositiveTest() {
        //int i = (int) ((System.currentTimeMillis()/1000)%3600);
        // click on Login link
        clickOnLoginLink();
        //enter Email
        fillRegisterForm(new User().setEmail("sopranom@gmail.com").setPassword("A1320$ak"));
        //click on Registration button
        clickOnRegistrationButton();
        //verify SingOut is displayed
        Assert.assertTrue(isSignOutPresent());

    }

    @Test
    public void exsistedUserRegistrationNegativeTest() {
        clickOnLoginLink();
        //enter Email
        fillRegisterForm(new User().setEmail("sopranom@gmail.com").setPassword("A1320$ak"));
        //click on Registration button
        clickOnRegistrationButton();
        //verify Alert displayed
        Assert.assertTrue(isAlertDisplayed());

    }

}

