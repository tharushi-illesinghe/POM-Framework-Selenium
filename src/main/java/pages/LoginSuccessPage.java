package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSuccessPage {

    WebDriver driver;

    //Create constructor
    public LoginSuccessPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[text()='Login Successfully']")
    public WebElement loginSuccessText_ele;

    public String loginSuccess(){
        String loginSuccessText = loginSuccessText_ele.getText();
        return loginSuccessText;
    }

}
