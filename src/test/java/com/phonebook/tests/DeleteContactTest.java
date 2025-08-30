package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeleteContactTest extends PhoneBookTestBase{
    //pricondition
    @BeforeMethod
    public void precondition(){
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "sopranom@gmail.com");
        type(By.name("password"), "A1320$ak");
        click(By.name("login"));


        click(By.cssSelector("[href='/add']"));
        type(By.cssSelector("input:nth-child(1)"),"Timmy");
        type(By.cssSelector("input:nth-child(2)"),"Turner");
        type(By.cssSelector("input:nth-child(3)"),"12345678910");
        type(By.cssSelector("input:nth-child(4)"),"tim@gmail.com");
        type(By.cssSelector("input:nth-child(5)"),"herzel");
        type(By.cssSelector("input:nth-child(6)"),"Qa");
        click(By.cssSelector(".add_main__1tbl_ button"));


    }
    @Test
    public void deleteContactTest(){
        int sizeBefore = sizeOfContacts();
        driver.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
        driver.findElement(By.xpath("//button[.='Remove']")).click();
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }

    private int sizeOfContacts() {
        if(isElementPresent(By.cssSelector(".contact-item_card__2SOIM")))
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        return 0;
    }
    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
