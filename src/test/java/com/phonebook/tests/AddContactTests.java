package com.phonebook.tests;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.utils.Data;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends PhoneBookTestBase{

    //pre conditions login
    @BeforeMethod
    public void precondition(){

            if (!app.getUser().isLoginLinkPresent()) {
                app.getUser().clicOnLogoutButton();
            }

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterForm(new User().setEmail(UserData.email).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
    }
    @Test
    public void addContactPositiveTest(){

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.NAME)
                .setLastName(ContactData.LASTNAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS)
                .setDescription(ContactData.DESCRIPTION));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(ContactData.NAME));




    }

    @Test(dataProvider = "addNewContact",dataProviderClass = Data.class)
    public void addContactPositiveFromDataProviderTest(String name,
                                                       String lastname,
                                                       String phone,
                                                       String email,
                                                       String address,
                                                       String description){


        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setLastName(lastname)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(description));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(name));




    }

    @Test(dataProvider = "addNewContactWithCsv",dataProviderClass = Data.class)
    public void addContactPositiveFromDataProviderWithCsvFileTest(Contact contact){

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(contact.getName()));



    }

    @AfterMethod
    public void postCondition(){
        app.getContact().deleteContact();

    }


}
