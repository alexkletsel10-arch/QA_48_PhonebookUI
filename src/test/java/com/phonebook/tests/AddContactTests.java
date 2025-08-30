package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends PhoneBookTestBase{

    //pre conditions login
    @BeforeMethod
    public void precondition(){
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "sopranom@gmail.com");
        type(By.name("password"), "A1320$ak");
        click(By.name("login"));
    }
    @Test
    public void addContactPositiveTest(){
        //click on link ADD
        click(By.cssSelector("[href='/add']"));
        //enter name
        type(By.cssSelector("input:nth-child(1)"),"Timmy");
        //enter lastname
        type(By.cssSelector("input:nth-child(2)"),"Turner");
        //enter phone
        type(By.cssSelector("input:nth-child(3)"),"12345678910");
        // enter email
        type(By.cssSelector("input:nth-child(4)"),"tim@gmail.com");
        //enter address
        type(By.cssSelector("input:nth-child(5)"),"herzel");
        // enter description
        type(By.cssSelector("input:nth-child(6)"),"Qa");
        //click Save button
        click(By.cssSelector(".add_main__1tbl_ button"));
        //verify contact is added
        Assert.assertTrue(isContactAdded("Timmy"));




    }

    public boolean isContactAdded(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for(WebElement element:contacts){
            if(element.getText().contains(text))
                return true;
        }
        return false;
    }
    @AfterMethod
    public void postCondition(){
        driver.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
        driver.findElement(By.xpath("//button[.='Remove']")).click();

    }


}
