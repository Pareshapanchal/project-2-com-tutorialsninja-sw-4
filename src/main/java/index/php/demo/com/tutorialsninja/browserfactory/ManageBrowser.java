package index.php.demo.com.tutorialsninja.browserfactory;

import index.php.demo.com.tutorialsninja.propertyreader.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ManageBrowser {
    public static WebDriver driver;
    static String baseUrl= PropertyReader.getInstance().getProperty("baseUrl");

    public void selectBrowser(String browser){
        if(browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();// It will open Chrome browser
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();//It will open FireFox browser
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver =new EdgeDriver();// It will open Edge browser
        }else {
            System.out.println("In Valid Browser Name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(baseUrl);
    }
    public void closeBrowser(){
        //it will colse all the browsers
        if(driver!=null){
            driver.quit();
        }
    }
}
