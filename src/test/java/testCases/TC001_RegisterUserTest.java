package testCases;

import Base.BaseClass;
import Functions.NewToursCommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.RegisterSuccessPage;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TC001_RegisterUserTest extends BaseClass {



    @Test
    public void TCOO1(){

        HomePage homePage = new HomePage(driver);
        homePage.selectRegisterMenu();

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.setFirstName("Isuri");
        registerPage.setLastName("Perera");
        registerPage.setEmail("abc@gmail.com");
        registerPage.selectCountry();
        registerPage.setUserName("Isuri");
        registerPage.setPassword("isuriTest123");
        registerPage.setConfirmPassword("isuriTest123");
        registerPage.clickSubmitBtn();


        RegisterSuccessPage registerSuccessPage = new RegisterSuccessPage(driver);
        String actualText = registerSuccessPage.registerSuccess();
        Assert.assertTrue(actualText.contains("Dear"),"Registration attempt failed");

    }





    //    public void registerUser(){
//
//        HomePage homePage = new HomePage(driver);
//        homePage.selectRegisterMenu();
//
//        RegisterPage registerPage = new RegisterPage(driver);
//        registerPage.setFirstName("Isuri");
//        registerPage.setLastName("Perera");
//        registerPage.setEmail("abc@gmail.com");
//        registerPage.selectCountry();
//        registerPage.setUserName("Isuri");
//        registerPage.setPassword("isuriTest123");
//        registerPage.setConfirmPassword("isuriTest123");
//        registerPage.clickSubmitBtn();
//    }

//    public void verifyRegistrationSuccess(){
//
//        RegisterSuccessPage registerSuccessPage = new RegisterSuccessPage(driver);
//        String actualText = registerSuccessPage.registerSuccess();
//
//        //Assert.assertEquals(actualText,"Dear","not navigated to Success Page");
//        Assert.assertTrue(actualText.contains("Dear"),"Registration attempt failed");
//    }

}
