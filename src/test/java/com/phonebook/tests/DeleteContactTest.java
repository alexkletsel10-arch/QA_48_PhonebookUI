package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTest extends PhoneBookTestBase{

    @BeforeMethod
    public void precondition(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterForm(new User().setEmail("sopranom@gmail.com").setPassword("A1320$ak"));
        app.getUser().clickOnLoginButton();


        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("Timmy")
                .setLastName("Turner")
                .setPhone("12345678910")
                .setEmail( "tim@gmail.com")
                .setAddress( "herzel")
                .setDescription( "Qa"));
        app.getContact().clickOnSaveButton();


    }
    @Test
    public void deleteContactTest(){
        int sizeBefore = app.getContact().sizeOfContacts();
        app.getContact().deleteContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }

}
