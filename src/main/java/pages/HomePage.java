package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    //Create constructor
    public HomePage(WebDriver driver){
        this.driver = driver;   //to perform actions
        PageFactory.initElements(driver,this);  //for element identification
    }

    @FindBy(linkText = "REGISTER")
    public WebElement registerBtn_ele;

    public void selectRegisterMenu(){
        registerBtn_ele.click();
    }

}
