package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class RegisterPage  {

    WebDriver driver;

    //Create constructor
    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(name ="firstName")
    public WebElement firstName_ele;

    public void setFirstName(String firstName){
        firstName_ele.sendKeys(firstName);
    }


    @FindBy(name ="lastName")
    public WebElement lastName_ele;

    public void setLastName(String lastName){
        lastName_ele.sendKeys(lastName);
    }


    @FindBy(id ="userName")
    public WebElement email_ele;

    public void setEmail(String email){
        email_ele.sendKeys(email);
    }


    @FindBy(xpath ="//select[@name='country']")
    public WebElement country_ele;

    public void selectCountry(){
        Select dropDownCountry = new Select(country_ele);
        dropDownCountry.selectByIndex(2);
    }


    @FindBy(id ="email")
    public WebElement userName_ele;

    public void setUserName(String userName){
        userName_ele.sendKeys(userName);
    }


    @FindBy(name ="password")
    public WebElement password_ele;

    public void setPassword(String password){
        password_ele.sendKeys(password);
    }


    @FindBy(name ="confirmPassword")
    public WebElement confirmPassword_ele;

    public void setConfirmPassword(String confirmPassword){
        confirmPassword_ele.sendKeys(confirmPassword);
    }


    @FindBy(name ="submit")
    public WebElement submitBtn_ele;

    public void clickSubmitBtn(){
        removePopup();
        submitBtn_ele.click();
    }


    public void removePopup() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("""
            document.querySelectorAll(
                '.cb-box__wrapper-center_modal,.cb-box__inner-drag,.cb-element__wrap'
                ).forEach(e => e.remove());
            """);
    }
}
