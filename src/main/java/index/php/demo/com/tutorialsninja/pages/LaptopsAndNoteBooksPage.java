package index.php.demo.com.tutorialsninja.pages;

import index.php.demo.com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNoteBooksPage extends Utility {
    By laptopAndNoteBooks =By.linkText("Laptops & Notebooks");
    By laptopAndNoteBooksText =By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By options =By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    By price =By.xpath("//p[@class ='price']");
    By sortBy =By.id("input-sort");
    By macbook = By.linkText("MacBook");
    By addToCartButton =By.xpath("//button[@id='button-cart']");
    By macbookText =By.xpath("//h1[contains(text(),'MacBook')]");
    By productAdded =By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");
    By shoppingCart = By.xpath("//a[contains(text(),'shopping cart')]");
    By viewCartButton =By.xpath("//strong[normalize-space()='View Cart']");
    By shoppingCartText =By.xpath("//div[@id='content']//h1");
    By macBookTitle =By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    By quantity =By.xpath("//input[contains(@name, 'quantity')]");
    //By changeQuantity =By.xpath("//input[@name='quantity");
    By updateQuantity =By.xpath("//i[@class='fa fa-refresh']");//input[@name='quantity
          //By.xpath("//button[contains(@data-original-title, 'Update')]");
    By shoppingCartMessage =By.xpath("//div[@id='checkout-cart']/div[1]");
    By total =By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");
    public void mouseHoverOnLaptopsAndNoteBooks(){
        mouseHoverOnElementAndClick(laptopAndNoteBooks);
    }
    public void selectMenuAndClickShowAllLaptopsAndNoteBooks(){
        selectAndClickOnTheElementFromTheList(options,"Show AllLaptops & Notebooks");
    }
    public List<Double> getExpectedPriceInDescendingOrder(){
        List<WebElement> products = driver.findElements(price);
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        return originalProductsPrice;
    }
    public List<Double> getActualPriceInDescendingOrder(){
        List<WebElement> products = driver.findElements(price);
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        return afterSortByPrice;
    }
    public void selectOptionFromSortByDropDown(String option){
        selectByVisibleTextFromDropDown(sortBy,option); }
    public void clickOnMacBook(){clickOnElement(macbook);}
    public String getMacBookText(){return getTextFromElement(macbookText);}
    public void clickOnAddToCartButton(){clickOnElement(addToCartButton);}
    public String getProductAddedMessage(){return getTextFromElement(productAdded);}
    public void clickOnShoppingCart(){clickOnElement(shoppingCart);}
    public void clickOnViewCart(){mouseHoverOnElementAndClick(viewCartButton);}
    public String getShoppingCartText(){
        return getTextFromElement(shoppingCartText);}
    public String getMacBookTitle(){
        return getTextFromElement(macBookTitle);
    }
    public void changeQuantityField(String qty){
        clearTheBox(quantity);
        sendTextToElement(quantity,qty);
    }
    public void clickOnUpdateButton(){clickOnElement(updateQuantity);}
    public String getShoppingCartMessage(){return getTextFromElement(shoppingCartMessage);}
    public String getTotal(){

        return getTextFromElement(total);}
}
