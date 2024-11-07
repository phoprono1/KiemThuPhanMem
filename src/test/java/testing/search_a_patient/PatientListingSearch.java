package testing.search_a_patient;

import base.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class PatientListingSearch extends BaseDriver {
    String usernameStr = "admin";
    String passwordStr = "Admin123";



    @Test
    public void patientListingSearch() {
        ome.mySendKeys(ome.usernamePlc, usernameStr);
        ome.mySendKeys(ome.passwordPlc, passwordStr);
        ome.myClick(ome.inpatientWard);
        ome.myClick(ome.loginButton);

        ome.myClick(ome.findPatientRecord);

        String[] searchFields = {"100P9K", "9999", "", " 100 ", "John", "wdfje", " John ", "john", "JOHN", "jOhN"};

        WebElement searchFieldElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("patient-search")));
        WebElement btnClean = wait.until(ExpectedConditions.elementToBeClickable(By.id("patient-search-clear-button")));

        for (String searchField : searchFields) {

            ome.myClick(btnClean);

            searchFieldElement.sendKeys(searchField);

            searchFieldElement.sendKeys(Keys.ENTER);

            try {
                Thread.sleep(3000);  // Đợi 4 giây
            } catch (InterruptedException e) {
                e.printStackTrace();  // In ra lỗi nếu có
            }
        }
    }
}
