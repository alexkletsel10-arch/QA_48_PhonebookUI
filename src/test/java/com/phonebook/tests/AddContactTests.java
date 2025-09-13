package com.phonebook.tests;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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
    @DataProvider
    public Iterator <Object[]>addNewContact(){
        List<Object[]>list=new ArrayList<>();

        list.add(new Object[]{"Sam", "Miller","1234567892", "samm13@gmail.com","Denver","QA"});
        list.add(new Object[]{"Sam", "Miller","1234567803", "samm12@gmail.com","Denver","QA"});
        list.add(new Object[]{"Sam", "Miller","1234567836", "samm11@gmail.com","Denver","QA"});
        return list.iterator();
    }
    @Test(dataProvider = "addNewContact")
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

    @AfterMethod
    public void postCondition(){
        app.getContact().deleteContact();

    }


}
