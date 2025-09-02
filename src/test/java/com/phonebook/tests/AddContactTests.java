package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends PhoneBookTestBase{

    //pre conditions login
    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        fillRegisterForm(new User().setEmail("sopranom@gmail.com").setPassword("A1320$ak"));
        clickOnLoginButton();
    }
    @Test
    public void addContactPositiveTest(){

        clickOnAddLink();
        fillContactForm(new Contact()
                .setName("Timmy")
                .setLastName("Turner")
                .setPhone("12345678910")
                .setEmail( "tim@gmail.com")
                .setAddress( "herzel")
                .setDescription( "Qa"));
        clickOnSaveButton();
        Assert.assertTrue(isContactAdded("Timmy"));




    }

    @AfterMethod
    public void postCondition(){
        deleteContact();

    }


}
