package testCases;

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

public class TC001_RegisterUserTest {

    WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-save-password-bubble");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demo.guru99.com/test/newtours/index.php");
    }

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


    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
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
