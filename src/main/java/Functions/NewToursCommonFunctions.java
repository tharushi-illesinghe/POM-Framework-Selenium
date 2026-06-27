package Functions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;

public class NewToursCommonFunctions {

    WebDriver driver;

    public NewToursCommonFunctions(WebDriver driver) {
        this.driver = driver;
    }

    public String registerUser(String fname, String lname, String email,
                               String uName, String password, String confirmPassword) {

        HomePage homePage = new HomePage(driver);
        homePage.selectRegisterMenu();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.setFirstName(fname);
        registerPage.setLastName(lname);
        registerPage.setEmail(email);
        registerPage.selectCountry();
        registerPage.setUserName(uName);
        registerPage.setPassword(password);
        registerPage.setConfirmPassword(confirmPassword);
        registerPage.clickSubmitBtn();

        RegisterSuccessPage registerSuccessPage = new RegisterSuccessPage(driver);
        String actualText = registerSuccessPage.registerSuccess();

        return actualText;

    }

    public void loginUser (String uname, String pwd) {

        RegisterSuccessPage registerSuccessPage = new RegisterSuccessPage(driver);
        registerSuccessPage.registerSuccess();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserNameLogin(uname);
        loginPage.setPasswordLogin(pwd);
        loginPage.clickSubmitBtn();

        LoginSuccessPage loginSuccessPage = new LoginSuccessPage(driver);
        loginSuccessPage.loginSuccess();

    }

}
