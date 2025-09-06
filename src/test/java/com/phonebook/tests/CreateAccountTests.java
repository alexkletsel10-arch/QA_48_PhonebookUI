package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class CreateAccountTests extends PhoneBookTestBase {

    SoftAssert softAssert = new SoftAssert();

    @Test(enabled = false)

    public void newUserRegistrationPositiveTest() {
        //int i = (int) ((System.currentTimeMillis()/1000)%3600);
        // click on Login link
        app.getUser().clickOnLoginLink();
        //enter Email
        app.getUser().fillRegisterForm(new User().setEmail("sopranom@gmail.com").setPassword("A1320$ak"));
        //click on Registration button
        app.getUser().clickOnRegistrationButton();
        //verify SingOut is displayed
        Assert.assertTrue(app.getUser().isSignOutPresent());

    }

    @Test
    public void exsistedUserRegistrationNegativeTest() {
        app.getUser().clickOnLoginLink();
        //enter Email
        app.getUser().fillRegisterForm(new User().setEmail("sopranom@gmail.com").setPassword("A1320$ak"));
        //click on Registration button
        app.getUser().clickOnRegistrationButton();
        //verify Alert displayed
        //Assert.assertTrue(isAlertDisplayed());
        softAssert.assertTrue(app.getUser().isAlertDisplayed());
        softAssert.assertTrue(app.getUser().isErrorMessagePresent());
        softAssert.assertAll();



    }

}

