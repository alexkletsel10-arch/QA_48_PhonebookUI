package com.phonebook.tests;

import com.phonebook.fw.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PhoneBookTestBase {

    protected ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp(){
        app.init();
    }

    @AfterMethod(enabled=false)
    public  void  tearDown(){

        app.stop();
    }

}
