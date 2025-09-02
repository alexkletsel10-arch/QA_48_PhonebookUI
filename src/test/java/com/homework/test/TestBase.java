package com.homework.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }


    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void clickOnRegistrationButton() {
        click(By.cssSelector(".button-1.register-next-step-button"));
    }

    public void fillInRegisterForm(User user) {
        type(By.cssSelector("#FirstName"), user.getFirstName());
        //Enter lastname
        type(By.cssSelector("[name='LastName']"), user.getLastName());
        //Enter Email
        type(By.cssSelector("#Email"), user.getEmail());
        //Enter Password
        type(By.cssSelector("#Password"), user.getPassword());
        //Enter Confirm password
        type(By.cssSelector("#ConfirmPassword"), user.getConfirmPassword());
        // Click on register button
    }

    public void clickOnGenderRadioButton() {
        click(By.cssSelector("#gender-male"));
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector(".ico-register"));
    }

    public boolean isContinueButtonPresent() {
        return isElementPresent(By.cssSelector("input[value='Continue']"));
    }

    public boolean isLogOutButtonPresent() {
        return isElementPresent(By.xpath("//a[text()='Log out']"));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("input[value='Log in']"));
    }

    public void fillLoginForm(User user) {
        type(By.cssSelector("#Email"),user.getEmail());
        //Enter Password
        type(By.cssSelector("#Password"), user.getPassword() );
    }

    public void clickOnLoginLink() {
        click(By.cssSelector(".ico-login"));
    }


    public void clickOnShoppingCartLink() {
        driver.findElement(By.linkText("Shopping cart")).click();
    }

    public void clickOnAddToCartButtton() {
        driver.findElement(By.cssSelector(".button-2.product-box-add-to-cart-button")).click();
    }

    public void selectItemNoteBook() {
        driver.findElement(By.cssSelector("[alt='Picture for category Notebooks']")).click();
    }

    public void selectComputerCategory() {
        driver.findElement(By.cssSelector("a[href='/computers']")).click();
    }

    public boolean isItemAdded(String text) {
        List<WebElement> items = driver.findElements(By.cssSelector(".product-name"));
        for (WebElement item : items) {
            if (item.getText().contains(text))
                return true;
        }
        return false;
    }

    public void clickOnUpgradePageButton() {
        driver.findElement(By.cssSelector(".button-2.update-cart-button")).click();
    }

    public void clickOnCheckBox() {
        driver.findElement(By.name("removefromcart")).click();
    }

    public int sizeOfItems() {
        if (isElementPresent(By.name("removefromcart"))){
            return driver.findElements(By.name("removefromcart")).size();

       }
        return 0;
}

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
