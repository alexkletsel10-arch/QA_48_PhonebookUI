package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePagePhoneBookTest extends PhoneBookTestBase {

    @Test
    public void isHomeComponentPresentTest(){
        //driver.findElement(By.cssSelector("div:nth-child(2)>div>div>h1"));
        //System.out.println("Home Componenet " + isHomeComponentPresent());
        Assert.assertTrue(app.getHome().isHomeComponentPresent());
    }

}
