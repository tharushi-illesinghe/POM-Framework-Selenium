package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterSuccessPage {

    WebDriver driver;

    //Create constructor
    public RegisterSuccessPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//b[contains(text(),'Dear')]")
    public WebElement successText_ele;

    public String registerSuccess(){
        String successText = successText_ele.getText();
        return successText;
    }


}
