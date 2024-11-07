package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CaptureVitalFormPage {
    private final WebDriver driver;
    private final By continueField = By.xpath("/html/body/div/div[3]/div[3]/div[1]/button[1]");
    private final By cancelField = By.xpath("/html/body/div/div[3]/div[3]/div[1]/button[2]");
    private final By toastField = By.xpath("/html/body/div[2]/div/div/p");
    private final By bmiField = By.id("calculated-bmi-wrapper");
    private final By noBMIField = By.id("no-calculated-bmi");
    private final By saveVitalsButton = By.xpath("/html/body/div[1]/div[3]/div[4]/form/div[2]/div/p[1]/button");

    public CaptureVitalFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFocusedField(String input) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".numeric-range.focused")));
        driver.findElement(By.cssSelector(".numeric-range.focused")).sendKeys(input);
    }

    public void pressEnter() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public String getErrorMessage() {
        List<WebElement> errorFields = driver.findElements(By.cssSelector(".error.field-error"));
        String errorField = null;
        for (WebElement e : errorFields) {
            if (!e.getText().isBlank() && !e.getText().isEmpty())
                errorField = e.getText();
        }
        return errorField;
    }

    public String getBMIFieldMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bmiField));
        return driver.findElement(bmiField).getText();
    }

    public String getNoBMIFieldMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(noBMIField));
        return driver.findElement(noBMIField).getText();
    }

    public String getToastField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(toastField));
        return driver.findElement(toastField).getText();
    }

    public void clickContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(continueField));
        driver.findElement(continueField).click();
    }

    public void clickCancelButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(cancelField));
        driver.findElement(cancelField).click();
    }

    public String getURLCurrent() {
        return driver.getCurrentUrl();
    }

    public void clickSaveButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(saveVitalsButton));
        driver.findElement(saveVitalsButton).click();
    }
}
