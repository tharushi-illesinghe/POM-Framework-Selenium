package Base;

import jdk.swing.interop.SwingInterOpUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.BaseClassFinder;

import java.time.Duration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BaseClass  {

    public WebDriver driver;

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

        String browser = "Chrome";

        switch (browser.toLowerCase()){
            case "chrome" :
                driver = new ChromeDriver(); break;
            case "edge" :
                driver = new EdgeDriver(); break;
            case "firefox" :
                driver = new FirefoxDriver(); break;
            default:
                System.out.println("Browser not supported : " +browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/index.php");


    }

    @AfterMethod
    public void CloseBrowser(){

        driver.quit();
    }

}
