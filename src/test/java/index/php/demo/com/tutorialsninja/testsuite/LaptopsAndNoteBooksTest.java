package index.php.demo.com.tutorialsninja.testsuite;

import index.php.demo.com.tutorialsninja.pages.LaptopsAndNoteBooksPage;
import index.php.demo.com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LaptopsAndNoteBooksTest extends BaseTest{
    LaptopsAndNoteBooksPage laptopsAndNoteBooksPage = new LaptopsAndNoteBooksPage();
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        laptopsAndNoteBooksPage.mouseHoverOnLaptopsAndNoteBooks();
        //1.2 Click on “Show AllLaptops & Notebooks”
        laptopsAndNoteBooksPage.selectMenuAndClickShowAllLaptopsAndNoteBooks();
        // Get all the products price and stored into array list
        List<Double> exptectedList = laptopsAndNoteBooksPage.getExpectedPriceInDescendingOrder();
          //1.3 Select Sort By "Price (High > Low)"
        laptopsAndNoteBooksPage.selectOptionFromSortByDropDown("Price (High > Low)");
        // After filter Price (High > Low) Get all the products price and stored into array list
        List<Double> actualPriceList= laptopsAndNoteBooksPage.getActualPriceInDescendingOrder();
        //1.4 Verify the Product price will arrange in High to Low order.
        Assert.assertEquals(actualPriceList,exptectedList,"Product not sorted by price High to Low");
    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException{
        // Select currency as £ Pound Sterling
        //clickOnElement(By.xpath("//span[contains(text(),'Currency')]"));
        //selectByContainsTextFromListOfElements(By.xpath("//ul[@class = 'dropdown-menu']/li"), "£Pound Sterling");
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        laptopsAndNoteBooksPage.mouseHoverOnLaptopsAndNoteBooks();
        //2.2 Click on “Show All Laptops & Notebooks”
        laptopsAndNoteBooksPage.selectMenuAndClickShowAllLaptopsAndNoteBooks();
        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNoteBooksPage.selectOptionFromSortByDropDown("Price (High > Low)");
        //2.4 Select Product “MacBook”
        laptopsAndNoteBooksPage.clickOnMacBook();
        //2.5 Verify the text “MacBook”
        Thread.sleep(2000);
        Assert.assertEquals(laptopsAndNoteBooksPage.getMacBookText(),"MacBook","MacBook Product not display");
        //2.6 Click on ‘Add To Cart’ button
        laptopsAndNoteBooksPage.clickOnAddToCartButton();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Thread.sleep(2000);
        Assert.assertTrue(laptopsAndNoteBooksPage.getProductAddedMessage().contains("Success: You have added MacBook to your shopping cart!"),"Product not added to cart");
        //2.8 Click on link “shopping cart” display into success message
         laptopsAndNoteBooksPage.clickOnShoppingCart();
         //Thread.sleep(2000);
        // laptopsAndNoteBooksPage.clickOnViewCart();
        //2.9 Verify the text "Shopping Cart"
        Thread.sleep(2000);
        Assert.assertTrue(laptopsAndNoteBooksPage.getShoppingCartText().contains("Shopping Cart"));
        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals(laptopsAndNoteBooksPage.getMacBookTitle(),"MacBook","Product name not matched");
        //2.11 Change Quantity "2"
        Thread.sleep(2000);
        laptopsAndNoteBooksPage.changeQuantityField("2");
        //2.12 Click on “Update” Tab
        laptopsAndNoteBooksPage.clickOnUpdateButton();
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertTrue(laptopsAndNoteBooksPage.getShoppingCartMessage().contains("Success: You have modified your shopping cart!"),"Cart not modified");
        //2.14 Verify the Total £737.45

        Assert.assertEquals(laptopsAndNoteBooksPage.getTotal(),"$1,204.00","Total not matched");


    }
}
