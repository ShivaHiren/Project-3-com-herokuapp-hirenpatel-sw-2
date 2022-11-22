package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        //click on link
        loginLink.click();
    }

    public void sendTextToElement(By by, String text) {
        //Send data to field
        driver.findElement(by).sendKeys(text);


    }

}