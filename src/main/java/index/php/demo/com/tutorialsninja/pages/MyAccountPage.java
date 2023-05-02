package index.php.demo.com.tutorialsninja.pages;

import index.php.demo.com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccountPage extends Utility {
    By myAccountlink =By.xpath("//span[contains(text(),'My Account')]");
    By listOfOptions =By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li");
    By returningCustomerText =By.xpath("//h2[contains(text(),'Returning Customer')]");
    By registerAccountText =By.xpath("//h1[contains(text(),'Register Account')]");
    By firstName=By.id("input-firstname");
    By lastName =By.id("input-lastname");
    By emailField =By.id("input-email");
    By telephone = By.id("input-telephone");
    By password =By.id("input-password");
    By confirmPassword =By.id("input-confirm");
    By subscribeRadioButton = By.xpath("//label[normalize-space()='Yes']");
    By privacyCheckbox =By.xpath("//div[@class = 'buttons']//input[@name='agree']");
    By continueButton =By.xpath("//div[@class = 'buttons']//input[@value='Continue']");
    By accoutCreatedText =By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
    By continueButton2 =By.xpath("//a[contains(text(),'Continue')]");
    By accountLogout =By.xpath("//h1[contains(text(),'Account Logout')]");
    By continueButton3 =By.xpath("//a[contains(text(),'Continue')]");
    By loginButton =By.xpath("//form[contains(@action,'login')]//input[@type='submit']");
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }

    public void sendFirstNameLastName(String firstname, String lastname){
        sendTextToElement(firstName,firstname);
        sendTextToElement(lastName,lastname);
    }
    public void sendPassword(String password1){
        sendTextToElement(password,password1);
    }
    public void sendEmail(String email){
        sendTextToElement(emailField,email);
    }
    public void sendTelephone(String phone){
        sendTextToElement(telephone,phone);
    }
    public void sendPasswordAndConfirmPassword(String password1, String confirmpassword){
        sendTextToElement(password,password1);
        sendTextToElement(confirmPassword,confirmpassword);
    }
    public void selectSubscribeRadioButton(String text){
     clickOnElement(subscribeRadioButton);
    }
    public void clickOnPrivacyPolicy(){
        clickOnElement(privacyCheckbox);
    }
    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }
    public String getAccountCreatedMessage(){
        return getTextFromElement(accoutCreatedText);
    }
    public void clickOnContinueButton2(){
        clickOnElement(continueButton2);
    }
    public String getAccountLogoutMessage(){
        return getTextFromElement(accountLogout);

    }
    public void clickOnContinueButton3(){
        clickOnElement(continueButton3);
    }
    public void clickOnMyAccountlink(){
        clickOnElement(myAccountlink);
    }
    public void print(){
        System.out.println(driver.findElement(registerAccountText).getText());
    }
    public String getReturningCustomerText(){return getTextFromElement(returningCustomerText); }
    public String getRegisterAccountText(){return getTextFromElement(registerAccountText);}
    public void selectMyAccountOptions(String option){
        List<WebElement> myAccountList = getListOfElements(listOfOptions);
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        }catch (StaleElementReferenceException e){
            myAccountList =getListOfElements(listOfOptions);
        }

    }
}
