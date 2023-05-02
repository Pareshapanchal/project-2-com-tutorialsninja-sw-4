package index.php.demo.com.tutorialsninja.testsuite;

import index.php.demo.com.tutorialsninja.pages.DesktopsPage;
import index.php.demo.com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DesktopsTest extends BaseTest {
    DesktopsPage desktopsPage = new DesktopsPage();
    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        desktopsPage.mouseHoverOnAndClickDesktops();
        //1.2 Click on “Show All Desktops”
        desktopsPage.selectMenuAndClickShowAllDesktops();
        //get exptected products name before filter
        List<String> expectedNameList = desktopsPage.getExpectedProductsNameInZtoAOrder();
        //1.3 Select Sort By position "Name: Z to A"
       desktopsPage.selectsortByOptionsFromDropDown("Name (Z - A)");
       // After filter Z -A Get all the products name and stored into array list
        List<String> actualNamelist= desktopsPage.getActualProductNameListAfterFilter();
        //1.4 Verify the Product will arrange in Descending order.
        Assert.assertEquals(actualNamelist,expectedNameList,"Product not sorted into Z to A order");
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        // Select currency as £ Pound Sterling
     //   desktopsPage.clickOnCurrency();
        Thread.sleep(2000);
       // desktopsPage.selectPoundSterling();
        //2.1 Mouse hover on Desktops Tab. and click
        desktopsPage.mouseHoverOnAndClickDesktops();
        //2.2 Click on “Show All Desktops”
        desktopsPage.selectMenuAndClickShowAllDesktops();
        //2.3 Select Sort By position "Name: A to Z"
        desktopsPage.selectsortByOptionsFromDropDown("Name (A - Z)");
        //2.4 Select product “HP LP3065”
         desktopsPage.clickOnHPLP3065();
        //2.5 Verify the Text "HP LP3065"
        Assert.assertEquals(desktopsPage.getHPLP3065Text(),"HP LP3065","HP LP3065 Product not display");
        //2.6 Select Delivery Date "2023-11-30"
        desktopsPage.clickOnCalenderButton();
       Thread.sleep(2000);
        desktopsPage.selectDateFromTheCalender("2023","November","30");
        //2.7.Enter Qty "1” using Select class.
        desktopsPage.changeQuantity("1");
        //2.8 Click on “Add to Cart” button
        desktopsPage.clickOnAddToCartButton();
        Thread.sleep(2000);
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String acctualMessage = desktopsPage.getProductAddedMessage();
        String expectedMessage ="Success: You have added HP LP3065 to your shopping cart!";
        boolean message = acctualMessage.contains(expectedMessage.trim());
        Assert.assertTrue(message);
        //2.10 Click on link “shopping cart” display into success message
          desktopsPage.clickOnShoppingCart();
          desktopsPage.clickOnViewCar();
        //2.11 Verify the text "Shopping Cart"
         Assert.assertTrue(desktopsPage.getShoppingCartText().contains("Shopping Cart"));
         //2.12 Verify the Product name "HP LP3065"
         Assert.assertEquals(desktopsPage.getProductTitle(),"HP LP3065","Product name not matched");
        //2.13 Verify the Delivery Date "2022-11-30"
        Assert.assertTrue( desktopsPage.getDeliveryDate().contains("2023-11-30"),"Delivery date not matched");
       //2.14 Verify the Model "Product21"
        Assert.assertEquals(desktopsPage.getProductModel(),"Product 21", "Model not matched");
        //2.15 Verify the Todat "£74.73"
        Assert.assertEquals(desktopsPage.getTotalText(),"$122.00","Total not matched");

    }
}
