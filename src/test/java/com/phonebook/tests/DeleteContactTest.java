package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTest extends PhoneBookTestBase{

    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        fillRegisterForm(new User().setEmail("sopranom@gmail.com").setPassword("A1320$ak"));
        clickOnLoginButton();


        clickOnAddLink();
        fillContactForm(new  Contact()
                .setName("Timmy")
                .setLastName("Turner")
                .setPhone("12345678910")
                .setEmail( "tim@gmail.com")
                .setAddress( "herzel")
                .setDescription( "Qa"));
        clickOnSaveButton();


    }
    @Test
    public void deleteContactTest(){
        int sizeBefore = sizeOfContacts();
        deleteContact();
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }

}
