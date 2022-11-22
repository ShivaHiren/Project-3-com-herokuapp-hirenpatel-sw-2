package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        //Launch website
        openBrowser(baseUrl);
    }


    @Test
    public void UserSholdLoginSuccessfullyWithValidCredentials() {
        ///click on username
        sendTextToElement(By.xpath("//input[@name='username']"), "tomsmith");
        //Enter password
        sendTextToElement(By.xpath("//input[@name='password']"), "SuperSecretPassword!");

        //click on login
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));

        //This is requirement
        String expectedMessage = "Secure Area";

        //Find the welcome test element and get the text
        WebElement actualTextMessageElement = BaseTest.driver.findElement(By.xpath(" //h2[contains(text(),' Secure Area')]"));
        String actualMessage = actualTextMessageElement.getText();
        //This is requirement
        Assert.assertEquals("Text matching succesfully:", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        ///click on username
        sendTextToElement(By.xpath("//input[@name='username']"), "tomsmith1");
        //Enter password
        sendTextToElement(By.xpath("//input[@name='password']"), "SuperSecretPassword!");

        //click on login
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));

        //This is requirement
        String expectedMessage = "Your username is invalid!\n" +
                "×";

        //Find the welcome test element and get the text
        WebElement actualTextMessageElement = BaseTest.driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualTextMessageElement.getText();
        //This is requirement
        Assert.assertEquals("Text matching succesfully:", expectedMessage, actualMessage);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        ///click on username
        sendTextToElement(By.xpath("//input[@name='username']"), "tomsmith");
        //Enter password
        sendTextToElement(By.xpath("//input[@name='password']"), "SuperSecretPassword");
        //click on login

        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));

        //This is requirement
        String expectedMessage = "Your password is invalid!\n" +
                "×";

        //Find the welcome test element and get the text
        WebElement actualTextMessageElement = BaseTest.driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualMessage = actualTextMessageElement.getText();
        //This is requirement
        Assert.assertEquals("Text matching succesfully:", expectedMessage, actualMessage);
    }

    @After
    public void testDown() {
        //Closing browser
        closeBrowser();
    }

}