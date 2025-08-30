package com.homework.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
  @Test
  public void loginPositiveTest(){
      //click on Login link
      click(By.cssSelector(".ico-login"));
      //Enter Email
      type(By.cssSelector("#Email"), "aaron18@gmail.com");
      //Enter Password
      type(By.cssSelector("#Password"), "Cadi26$lac");
      // click on Login button
      click(By.cssSelector("input[value='Log in']"));
      //verify Logout Button is displayed
      Assert.assertTrue(isElementPresent(By.xpath("//a[text()='Log out']")));


  }

}
