package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends PhoneBookTestBase{
    @Test
    public void loginPositiveTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterForm(new User().setEmail("sopranom@gmail.com").setPassword("A1320$ak"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutPresent());

    }

    @Test
    public void loginNegativeWitouthEmailTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterForm(new User().setPassword("A1320$ak"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());

    }


}
