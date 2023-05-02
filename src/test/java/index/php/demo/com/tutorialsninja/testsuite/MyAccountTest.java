package index.php.demo.com.tutorialsninja.testsuite;

import index.php.demo.com.tutorialsninja.pages.MyAccountPage;
import index.php.demo.com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {
    MyAccountPage accountPage = new MyAccountPage();


    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException{
        //1.1 Click on My Account Link.
        accountPage.clickOnMyAccountlink();
        //accountPage.print();
        Thread.sleep(2000);
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter "Register”
        accountPage.selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”.
        Assert.assertEquals(accountPage.getRegisterAccountText(),"Register Account","Register page not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        accountPage.clickOnMyAccountlink();
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        accountPage.selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”.
        Assert.assertEquals(accountPage.getReturningCustomerText(),"Returning Customer","Login page not displayed");
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Click on My Account Link.
        accountPage.clickOnMyAccountlink();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        accountPage.selectMyAccountOptions("Register");
        //3.3 Enter First Name//3.4 Enter Last Name
        accountPage.sendFirstNameLastName("rina","patel");
        //3.5 Enter Email
        accountPage.sendEmail("rina@gmail.com");
        //3.6 Enter Telephone
        accountPage.sendTelephone("07988112233");
        //3.7 Enter Password //3.8 Enter Password Confirm
        accountPage.sendPasswordAndConfirmPassword("rina123","rina123");
        //3.9 Select Subscribe Yes radio button
        accountPage.selectSubscribeRadioButton("Yes");
        //3.10 Click on Privacy Policy check box
        accountPage.clickOnPrivacyPolicy();
        //3.11 Click on Continue button
        accountPage.clickOnContinueButton();
        //3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(accountPage.getAccountCreatedMessage(), "Your Account Has Been Created!", "Error");
        //3.13 Click on Continue button
        accountPage.clickOnContinueButton2();
        //3.14 Click on My Account Link.
        accountPage.clickOnMyAccountlink();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        accountPage.selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        String expectedMessage = "Account Logout";
        String actualMessage = accountPage.getAccountLogoutMessage();
        Assert.assertEquals(actualMessage,expectedMessage,"Not logged out");
        //3.17 Click on Continue button
        accountPage.clickOnContinueButton3();
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on My Account Link.
        accountPage.clickOnMyAccountlink();
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter "Login”
        accountPage.selectMyAccountOptions("Login");
        //4.3 Enter Email address
        accountPage.sendEmail("prime1233@gmail.com");
        //4.4 Enter Password
        accountPage.sendPassword("test1234");
        //4.5 Click on Login button
       accountPage.clickOnLoginButton();
        //4.8 Click on My Account Link.
       accountPage.clickOnMyAccountlink();
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        accountPage.selectMyAccountOptions("Logout");
        //4.10 Verify the text “Account Logout”
        String expectedMessage = "Account Logout";
        String actualMessage = accountPage.getAccountLogoutMessage();
        Assert.assertEquals(actualMessage,expectedMessage,"Not logged out");
        //4.11 Click on Continue button
         accountPage.clickOnContinueButton3();
    }



}
