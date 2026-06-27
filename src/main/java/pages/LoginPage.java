package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    //Create constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(name = "userName")
    public WebElement  userName_ele;

    public void setUserNameLogin(String userName){
        userName_ele.sendKeys(userName);
    }


    @FindBy(name = "password")
    public WebElement password_ele;

    public void setPasswordLogin(String password){
        password_ele.sendKeys(password);
    }


    @FindBy(name = "submit")
    public WebElement submitBtn_ele;

    public void clickSubmitBtn(){
        submitBtn_ele.click();
    }

}
