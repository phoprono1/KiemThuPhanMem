package FindPatient;


import org.example.pages.PatientRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FindPatientRecord {

    public static void FindPatientRecord() {

        WebDriver driver = WebConnect.connect();
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Admin123");

        WebElement locationDropdown = driver.findElement(By.id("sessionLocation"));


        locationDropdown.click();

        WebElement desiredLocationOption = driver.findElement(By.cssSelector("li[value='6']")); // Replace '4' with the desired value

        desiredLocationOption.click();

        String selectedLocation = desiredLocationOption.getText();
        System.out.println("Selected Location: " + selectedLocation);

        WebElement button =  driver.findElement(By.xpath("//*[@id=\"loginButton\"]"));
        button.click();

//        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();



        WebElement buttonFind = driver.findElement(By.xpath("/html/body/div/div[3]/div[3]/div/a[1]"));
        buttonFind.click();

        PatientRecord p1 = new PatientRecord("1001PD", "Mary Thompson");
        PatientRecord p2 = new PatientRecord("1003FW", "John White");
        WebElement findField = driver.findElement(By.id("patient-search"));

//        search by id
        findField.sendKeys(p1.getId());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findField.clear();

//        search by name
        findField.sendKeys(p1.getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findField.clear();

//        search by Wrong data
        findField.sendKeys("123abcxyzhkt");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findField.clear();

        //        search by Multiple name
        findField.sendKeys(p2.getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findField.clear();

        //        search by Blank Space
        findField.sendKeys("    ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findField.clear();

//        driver.quit();
    }
}