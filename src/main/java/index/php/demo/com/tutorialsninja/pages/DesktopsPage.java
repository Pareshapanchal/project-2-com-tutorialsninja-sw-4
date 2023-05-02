package index.php.demo.com.tutorialsninja.pages;

import index.php.demo.com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

public class DesktopsPage extends Utility {
    By desktop =By.linkText("Desktops");
    By options =By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    By products =By.xpath("//h4/a");
    By sortBy =By.id("input-sort");
    By currency =By.xpath("//span[normalize-space()='Currency']");
    By poundSterling =By.xpath("//button[normalize-space()='£Pound Sterling']");
    By hplp3065=By.xpath("//a[contains(text(),'HP LP3065')]");
    By hplb3065Text= By.xpath("//h1[contains(text(),'HP LP3065')]");
    By calenderButton =By.xpath("//div[@class = 'input-group date']//button");
    By calenderMonthAndYear =By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']");
    By nextButtonOnCalender =By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']");
    By datesOnCalender =By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");
    By addToCartButton =By.xpath("//button[@id='button-cart']");
    By quantity =By.xpath("//input[@id='input-quantity']");
    By productAddedText =By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By shoppingCartButton =By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']");
    By viewCartButton =By.xpath("//strong[normalize-space()='View Cart']");
    By shoppingCartText =By.xpath("//h1[contains(text(),'Shopping Cart')]");
    By productname =By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    By deliveryDate =By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");
    By productModel =By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");
    By total =By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");

    public void mouseHoverOnAndClickDesktops(){ mouseHoverOnElementAndClick(desktop); }
    public void selectMenuAndClickShowAllDesktops(){selectAndClickOnTheElementFromTheList(options,"Show AllDesktops");}
    public List<String> getExpectedProductsNameInZtoAOrder(){
        List<String> list = getTheListOfElementFromTheList(products);
        Collections.reverse(list);
        return list;
    }
    public void selectsortByOptionsFromDropDown(String text){ selectByVisibleTextFromDropDown(sortBy,text);  }
    public List<String> getActualProductNameListAfterFilter(){
        List<String> list = getTheListOfElementFromTheList(products);
        return list;
    }
    public void clickOnCurrency(){ mouseHoverOnElementAndClick(currency);    }
    public void selectPoundSterling(){selectByContainsTextFromDropDown(poundSterling,"£Pound Sterling");    }
    public void clickOnHPLP3065(){ clickOnElement(hplp3065);    }
    public String getHPLP3065Text(){ return getTextFromElement(hplb3065Text);    }
    public void clickOnCalenderButton(){ clickOnElement(calenderButton);    }
    public void selectDateFromTheCalender(String year,String month, String date){
        while (true) {
            String monthAndYear = getTextFromElement(calenderMonthAndYear);
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButtonOnCalender);
            }
        }
        List<WebElement> allDates = driver.findElements(datesOnCalender);
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }
    public void clickOnAddToCartButton(){
        clickOnElement(addToCartButton);
    }
    public String getProductAddedMessage(){
        return getTextFromElement(productAddedText);
    }
    public String getShoppingCartText(){
        return getTextFromElement(shoppingCartText);
    }
 public void changeQuantity(String qty){
        clearTheBox(quantity);
        sendTextToElement(quantity,qty);
 }
 public void clickOnShoppingCart(){clickOnElement(shoppingCartButton); }
    public void clickOnViewCar(){clickOnElement(viewCartButton);
    }
 public String getProductTitle(){ return getTextFromElement(productname);}
 public String getDeliveryDate(){return getTextFromElement(deliveryDate);}
 public String getProductModel(){return getTextFromElement(productModel);}
public String getTotalText(){return getTextFromElement(total);}
}
