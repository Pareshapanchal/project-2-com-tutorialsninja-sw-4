package index.php.demo.com.tutorialsninja.testsuite;

import index.php.demo.com.tutorialsninja.pages.TopMenuPage;
import index.php.demo.com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {
    TopMenuPage topMenuPage = new TopMenuPage();
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
      topMenuPage.mouseHoverOnAndClickDesktops();
        //1.2 call selectMenu method and pass the menu = “Show AllDesktops”
         topMenuPage.selectMenuAndClickShowAllDesktops();
        //1.3 Verify the text ‘Desktops’
        String expectedText = "Desktops";
        String actualText = topMenuPage.getDesktopText();
        Assert.assertEquals( actualText,expectedText,"Not navigate to Desktop page");
    }

   @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
       topMenuPage.mouseHoverOnLaptopsAndNoteBooks();
        //2.2 call selectMenu method and pass the menu = “Show AllLaptops & Notebooks”
        topMenuPage.selectMenuAndClickShowAllLaptopsAndNoteBooks();
        //2.3 Verify the text ‘Laptops & Notebooks’
        Assert.assertEquals("Laptops & Notebooks", topMenuPage.getLaptopAndNoteBooksText(),"Not navigate to Laptops and Notebooks page");

    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        topMenuPage.mouseHoverAndClickOnComponents();
        //3.2 call selectMenu method and pass the menu = “Show AllComponents”
        topMenuPage.selectMenuAndClickShowAllComponents();
        //3.3 Verify the text ‘Components’

        Assert.assertEquals(topMenuPage.getComponentText(),"Components","Not navigate to Laptops and Notebooks page");

    }

}
