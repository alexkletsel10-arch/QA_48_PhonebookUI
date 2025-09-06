package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends PhoneBookTestBase{

    //pre conditions login
    @BeforeMethod
    public void precondition(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterForm(new User().setEmail("sopranom@gmail.com").setPassword("A1320$ak"));
        app.getUser().clickOnLoginButton();
    }
    @Test
    public void addContactPositiveTest(){

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("Timmy")
                .setLastName("Turner")
                .setPhone("12345678910")
                .setEmail( "tim@gmail.com")
                .setAddress( "herzel")
                .setDescription( "Qa"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded("Timmy"));




    }

    @AfterMethod
    public void postCondition(){
        app.getContact().deleteContact();

    }


}
