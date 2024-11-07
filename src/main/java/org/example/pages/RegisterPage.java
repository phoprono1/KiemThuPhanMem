package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RegisterPage {

    private WebDriver driver;
    private By register = By.xpath("//*[@id=\"referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension\"]");
    private By givenNameTxt = By.name("givenName");
    private By middleNameTxt = By.name("middleName");
    private By familyNameTxt = By.name("familyName");
    private By checkBox = By.xpath("//*[@id=\"checkbox-unknown-patient\"]");
    private By next = By.xpath("//*[@id=\"next-button\"]");
    private By genderTxt = By.name("gender");
    private By birthdateDayTxt = By.name("birthdateDay");
    private By selectBirthdateDay = By.xpath("/html/body/div/div[3]/form/section[1]/div/fieldset[3]/p[3]/select");
    private By birthdateYearTxt = By.name("birthdateYear");
    private By addressTxt = By.id("address1");
    private By addressTxt2 = By.id("address2");
    private By cityVillageTxt = By.id("cityVillage");
    private By stateProvinceTxt = By.id("stateProvince");
    private By countryTxt = By.id("country");
    private By postalCodeTxt = By.id("postalCode");
    private By phoneNumberTxt = By.name("phoneNumber");
    private By selectRelationship = By.xpath("//*[@id=\"relationship_type\"]/option[2]");
    private By personNameTxt = By.xpath("//*[@class=\"person-typeahead\"]");
    private By confirm = By.xpath("//*[@id=\"submit\"]");
    private final By toastField = By.xpath("/html/body/div[2]/div/div/p");

    public String getToastField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(toastField));
        return driver.findElement(toastField).getText();
    }

    public String getErrorMessage() {
        List<WebElement> errorFields = driver.findElements(By.cssSelector(".field-error"));
        String errorField = null;
        for (WebElement e : errorFields) {
            if (!e.getText().isBlank() && !e.getText().isEmpty())
                errorField = e.getText();
        }
        return errorField;
    }



    public RegisterPage(WebDriver driver){
        this.driver =driver;
    }

    public void register(){
        driver.findElement(register).click();
    }

    public void setGivenName(String givenName){
        driver.findElement(givenNameTxt).sendKeys(givenName);
    }

    public void setMiddleName(String middleName){
        driver.findElement(middleNameTxt).sendKeys(middleName);
    }

    public void setFamilyName(String familyName){
        driver.findElement(familyNameTxt).sendKeys(familyName);
    }

    public void clickNext(){
        driver.findElement(next).click();
    }

    public void setGender(String gender){
        driver.findElement(genderTxt).sendKeys(gender);
    }

    public void setBirthdateDay(String birthdateDay){
        driver.findElement(birthdateDayTxt).sendKeys(birthdateDay);
    }

    public void setBirthdateMonth(String SearchTxt){
        driver.findElement(selectBirthdateDay).sendKeys(SearchTxt);
    }

    public void setBirthdateYear(String birthdateYear){
        driver.findElement(birthdateYearTxt).sendKeys(birthdateYear);
    }
    public void setAddress1(String address1){
        driver.findElement(addressTxt).sendKeys(address1);
    }
    public void setAddress2(String address2){
        driver.findElement(addressTxt2).sendKeys(address2);
    }
    public void setCityVillage(String cityVillage){
        driver.findElement(cityVillageTxt).sendKeys(cityVillage);
    }
    public void setStateProvince(String stateProvince){
        driver.findElement(stateProvinceTxt).sendKeys(stateProvince);
    }
    public void setCountry(String country){
        driver.findElement(countryTxt).sendKeys(country);
    }
    public void setPostalCode(String postalCode){
        driver.findElement(postalCodeTxt).sendKeys(postalCode);
    }
    public void setPhoneNumber(String phoneNumber){
        driver.findElement(phoneNumberTxt).sendKeys(phoneNumber);
    }
    public void setSelectRelationship(){
        driver.findElement(selectRelationship).click();
    }

    public  SecureAreaPage clickConfirm(){
        driver.findElement(confirm).click();
        return new SecureAreaPage(driver);
    }

}
