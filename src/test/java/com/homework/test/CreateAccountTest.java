package com.homework.test;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateAccountTest extends TestBase {
    @Test
    public void newUserRegistrationPositiveTest() {
        //int i = (int) ((System.currentTimeMillis()/1000)%3600);
        //click on Register link
        clickOnRegisterLink();
        //Select gender radio button
        clickOnGenderRadioButton();
        //driver.findElement(By.cssSelector("#gender-male")).clear();
        //findElement(By.cssSelector("#gender-female")).click()
        //Enter first name
        fillInRegisterForm(new User()
                .setFirstName("Aaron")
                .setLastName( "Kennedy")
                .setEmail( "aaron18@gmail.com")
                .setPassword( "Cadi26$lac")
                .setConfirmPassword("Cadi26$lac"));
        clickOnRegistrationButton();
        //verify LogOut link is displayed
        Assert.assertTrue(isLogOutButtonPresent());
        //verify Continue button is displayed
        Assert.assertTrue(isContinueButtonPresent());


    }



}


