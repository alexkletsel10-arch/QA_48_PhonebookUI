package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends PhoneBookTestBase{
    @BeforeMethod
    public void ensurePrecondition() {
            if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clicOnLogoutButton();
        }
    }
    @Test(priority = 1)
    public void loginPositiveTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterForm(new User().setEmail(UserData.email).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutPresent());

    }

    @Test(priority = 2)
    public void loginNegativeWitouthEmailTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterForm(new User().setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());

    }


}
