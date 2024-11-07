package testing.view_the_patient_details;

import base.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class PatientDetailsView extends BaseDriver {
    String usernameStr = "admin";
    String passwordStr = "Admin123";

    @Test
    public void patientListing() {
        ome.mySendKeys(ome.usernamePlc, usernameStr);
        ome.mySendKeys(ome.passwordPlc, passwordStr);
        ome.myClick(ome.inpatientWard);
        ome.myClick(ome.loginButton);

        ome.myClick(ome.findPatientRecord);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String patientIdentifier = "100JEG";

        String xpath = "//table[@id='patient-search-results-table']//td[contains(text(), '" + patientIdentifier + "')]";
        WebElement patientCell = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        patientCell.click();

        System.out.println("Đã click vào trang chi tiết bệnh nhân có Identifier: " + patientIdentifier);
    }

}
