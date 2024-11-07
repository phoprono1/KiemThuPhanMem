package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ParentPage {
    public WebDriverWait wait = new WebDriverWait(BaseDriver.driver, Duration.ofSeconds(10));

    public void myClick(WebElement e) {
        wait.until(ExpectedConditions.elementToBeClickable(e));
        scrollToElement(e);
        e.click();
    }

    public void mySendKeys(WebElement e, String txt) {
        wait.until(ExpectedConditions.visibilityOf(e));
        scrollToElement(e);
        e.clear();
        e.sendKeys(txt);
    }

    public void scrollToElement(WebElement e) {
        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.driver;
        js.executeScript("arguments[0].scrollIntoView();", e);
    }


    public void verifyContainsText(WebElement e, String txt) {
        wait.until(ExpectedConditions.textToBePresentInElement(e, txt));
        Assert.assertTrue(e.getText().toLowerCase().contains(txt.toLowerCase()));

        //ESC button in case of close notification
        new Actions(BaseDriver.driver).sendKeys(Keys.ESCAPE).build().perform();
    }

}
