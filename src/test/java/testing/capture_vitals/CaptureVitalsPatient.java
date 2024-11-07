package testing.capture_vitals;

import base.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CaptureVitalsPatient extends BaseDriver {

    String usernameStr = "admin";
    String passwordStr = "Admin123";

    // Helper method for login
    private void login() {
        ome.mySendKeys(ome.usernamePlc, usernameStr);
        ome.mySendKeys(ome.passwordPlc, passwordStr);
        ome.myClick(ome.inpatientWard);
        ome.myClick(ome.loginButton);
    }

    // Helper method to perform search for patient
    private void searchPatient(String patientName) {
        WebElement searchFieldElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("patient-search")));
        WebElement btnClean = wait.until(ExpectedConditions.elementToBeClickable(By.id("patient-search-clear-button")));
        ome.myClick(btnClean);
        searchFieldElement.sendKeys(patientName);
        searchFieldElement.sendKeys(Keys.ENTER);
    }

    // Test Case 1: Successful capture of vital data for a patient
    @Test
    public void testCaptureVitals() {
        login();
        ome.myClick(ome.captureVitals);


        searchPatient("HASSAN\n" +
                "Given\n" +
                " DAGANE\n" +
                "Middle\n" +
                " ALI");

        WebElement coreappsVitalsConfirm = wait.until(ExpectedConditions.elementToBeClickable(By.id("coreapps-vitals-confirm")));
        ome.myClick(coreappsVitalsConfirm);

        ome.mySendKeys(ome.w8, "170");
        ome.myClick(ome.nextButtonn);
        ome.mySendKeys(ome.w10, "65");
        ome.myClick(ome.nextButtonn);
        ome.myClick(ome.nextButtonn);
        ome.mySendKeys(ome.w12, "37");
        ome.myClick(ome.nextButtonn);
        ome.mySendKeys(ome.w14, "85");
        ome.myClick(ome.nextButtonn);
        ome.mySendKeys(ome.w16, "20");
        ome.myClick(ome.nextButtonn);
        ome.mySendKeys(ome.w18, "120");
        ome.mySendKeys(ome.w20, "80");
        ome.myClick(ome.nextButtonn);
        ome.mySendKeys(ome.w22, "99");
        ome.myClick(ome.nextButtonn);

        // Assertion can be added to validate that the patient data has been captured successfully
    }

    // Test Case 2: Invalid height (-1)
    @Test
    public void testInvalidHeight() {
        login();
        ome.myClick(ome.captureVitals);
        searchPatient("HASSAN Given DAGANE Middle ALI");

        ome.myClick(wait.until(ExpectedConditions.elementToBeClickable(By.id("coreapps-vitals-confirm"))));

        ome.mySendKeys(ome.w8, "-1");  // Invalid height
        ome.myClick(ome.nextButtonn);

        // Add assertion to verify the error handling, e.g., "Invalid height"
        Assert.assertTrue(ome.errorMessage.isDisplayed());


    }

    // Test Case 3: Invalid height (280)
    @Test
    public void testExcessiveHeight() {
        login();
        ome.myClick(ome.captureVitals);
        searchPatient("HASSAN Given DAGANE Middle ALI");

        ome.myClick(wait.until(ExpectedConditions.elementToBeClickable(By.id("coreapps-vitals-confirm"))));

        ome.mySendKeys(ome.w8, "280");  // Excessive height
        ome.myClick(ome.nextButtonn);

        // Add assertion to verify the error handling, e.g., "Height exceeds maximum"
        Assert.assertTrue(ome.errorMessage.isDisplayed());
    }

    // Test Case 4: Invalid height (non-numeric input)
    @Test
    public void testNonNumericHeight() {
        login();
        ome.myClick(ome.captureVitals);
        searchPatient("HASSAN Given DAGANE Middle ALI");

        ome.myClick(wait.until(ExpectedConditions.elementToBeClickable(By.id("coreapps-vitals-confirm"))));

        ome.mySendKeys(ome.w8, "a");  // Non-numeric height
        ome.myClick(ome.nextButtonn);

        // Add assertion for handling non-numeric input for height
        Assert.assertTrue(ome.errorMessage.isDisplayed());
    }

    // Test Case 5: Invalid weight (-1)
    @Test
    public void testInvalidWeight() {
        login();
        ome.myClick(ome.captureVitals);
        searchPatient("HASSAN Given DAGANE Middle ALI");

        ome.myClick(wait.until(ExpectedConditions.elementToBeClickable(By.id("coreapps-vitals-confirm"))));

        ome.mySendKeys(ome.w10, "-1");  // Invalid weight
        ome.myClick(ome.nextButtonn);

        // Add assertion for invalid weight handling
        Assert.assertTrue(ome.errorMessage.isDisplayed());
    }

    // Test Case 6: Excessive weight (255)
    @Test
    public void testExcessiveWeight() {
        login();
        ome.myClick(ome.captureVitals);
        searchPatient("HASSAN Given DAGANE Middle ALI");

        ome.myClick(wait.until(ExpectedConditions.elementToBeClickable(By.id("coreapps-vitals-confirm"))));

        ome.mySendKeys(ome.w10, "255");  // Excessive weight
        ome.myClick(ome.nextButtonn);

        // Add assertion to verify error handling for excessive weight
        Assert.assertTrue(ome.errorMessage.isDisplayed());
    }

    // Test Case 7: Invalid temperature (10)
    @Test
    public void testLowTemperature() {
        login();
        ome.myClick(ome.captureVitals);
        searchPatient("HASSAN Given DAGANE Middle ALI");

        ome.myClick(wait.until(ExpectedConditions.elementToBeClickable(By.id("coreapps-vitals-confirm"))));

        ome.mySendKeys(ome.w12, "10");  // Too low temperature
        ome.myClick(ome.nextButtonn);

        // Add assertion for invalid temperature
        Assert.assertTrue(ome.errorMessage.isDisplayed());
    }

    // Test Case 8: Excessive temperature (50)
    @Test
    public void testHighTemperature() {
        login();
        ome.myClick(ome.captureVitals);
        searchPatient("HASSAN Given DAGANE Middle ALI");

        ome.myClick(wait.until(ExpectedConditions.elementToBeClickable(By.id("coreapps-vitals-confirm"))));

        ome.mySendKeys(ome.w12, "50");  // Too high temperature
        ome.myClick(ome.nextButtonn);

        // Add assertion for high temperature
        Assert.assertTrue(ome.errorMessage.isDisplayed());
    }
}
