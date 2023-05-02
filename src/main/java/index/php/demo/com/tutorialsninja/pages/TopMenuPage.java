package index.php.demo.com.tutorialsninja.pages;

import index.php.demo.com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class TopMenuPage extends Utility {
    By desktop =By.linkText("Desktops");
    By options =By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    By desktopText = By.xpath("//h2[contains(text(),'Desktops')]");
    By laptopAndNoteBooks =By.linkText("Laptops & Notebooks");
    By laptopAndNoteBooksText =By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By components = By.linkText("Components");
    By componentsText =By.xpath("//h2[contains(text(),'Components')]");
    public void mouseHoverOnAndClickDesktops(){
        mouseHoverOnElementAndClick(desktop);
    }
    public void selectMenuAndClickShowAllDesktops(){
selectAndClickOnTheElementFromTheList(options,"Show AllDesktops");
    }
    public String getDesktopText(){
        return getTextFromElement(desktopText);
    }
    public void mouseHoverOnLaptopsAndNoteBooks(){
        mouseHoverOnElementAndClick(laptopAndNoteBooks);
    }
    public void selectMenuAndClickShowAllLaptopsAndNoteBooks(){
        selectAndClickOnTheElementFromTheList(options,"Show AllLaptops & Notebooks");
    }
    public String getLaptopAndNoteBooksText(){
        return getTextFromElement(laptopAndNoteBooksText);
    }
    public void mouseHoverAndClickOnComponents(){
        mouseHoverOnElementAndClick(components);
    }
    public void selectMenuAndClickShowAllComponents(){
        selectAndClickOnTheElementFromTheList(options,"Show AllComponents");
    }
    public String getComponentText(){
        return getTextFromElement(componentsText);
    }

}
