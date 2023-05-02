package index.php.demo.com.tutorialsninja.utilities;

import index.php.demo.com.tutorialsninja.browserfactory.ManageBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Utility extends ManageBrowser {
    //This method will click on element
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
    //This method will get Text from element
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    // This method will send Text to element
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    public void clearTheBox(By by){
        driver.findElement(by).clear();
    }
    //This method will use to hover mouse on the element
    public void mouseHoverOnElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }
    // This method will use to hover mouse on element and click
    public void mouseHoverOnElementAndClick(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
    // This method will select text from the dropdown box by using value
    public void selectbyValueFromDropDown(By by, String value){
        new Select(driver.findElement(by)).selectByValue(value);}
    //This method will select element by providing visible text
    public void selectByVisibleTextFromDropDown(By by, String text){
        new Select(driver.findElement(by)).selectByVisibleText(text);}
    //This method will select element by providing index
    public void selectByIndexFromDropDown(By by, int index){
        new Select(driver.findElement(by)).selectByIndex(index);}
    //This method will select the option by contain text
    public void selectByContainsTextFromDropDown(By by, String text){
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for(WebElement options : allOptions){
            if(options.getText().contains(text)){options.click();}
        }
    }

    //This method will close all the windows
    public void closeAllWindows(List<String> hList, String parentWindow){
        for(String str : hList){
            if(!str.equals(parentWindow)){
                driver.switchTo().window(str).close();
            }
        }
    }
    //This method will switch to parent window
    public void switchToParentWindows(String parentWindowId){
        driver.switchTo().window(parentWindowId);
    }
    public boolean switchToRightWindow(String windowTitle, List<String> hList){
        for(String str: hList){
            String title = driver.switchTo().window(str).getTitle();
            if(title.contains(windowTitle)){
                System.out.println("Found the right window...");
                return true;
            }
        }
        return false;
    }
    //This method will use to wait until Visibility OfElementLocated
    public WebElement waitUntilVisibilityOfElementLocated(By by, int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //This method will select the particular element from the list and click on that particular element
    public void selectAndClickOnTheElementFromTheList(By by, String text) {
        List<WebElement> listofMenu = new ArrayList<>();
        listofMenu = driver.findElements(by);
        for (WebElement title : listofMenu) {
            if (title.getText().contains(text)) {
                title.click();
                break;
            }
        }
    }
    public List<WebElement> getListOfElements(By by){
        return driver.findElements(by);}
    //this method will store the text from the list of element in the string arraylist
    public List<String> getTheListOfElementFromTheList(By by){
        List<WebElement> productTitles = driver.findElements(by);
        List<String> listOfTitle = new LinkedList<>();
        for(int i =0; i<productTitles.size();i++){
            String s = productTitles.get(i).getText();
            listOfTitle.add(s);
        }
        return listOfTitle;
    }

}
