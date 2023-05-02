package index.php.demo.com.tutorialsninja.testbase;

import index.php.demo.com.tutorialsninja.propertyreader.PropertyReader;
import index.php.demo.com.tutorialsninja.utilities.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utility {
    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod// Before every method this method will be invoked and will open the particular browser
    public void setUp(){selectBrowser(browser);}
    @AfterMethod// After every method this method will be invoked, and it will close all the browsers.
    public void tearDown(){//closeBrowser();
    }
}
