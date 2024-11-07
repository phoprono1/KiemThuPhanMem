package testing.register_a_patient;

import base.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatientRegistration extends BaseDriver {

    String usernameStr = "admin";
    String passwordStr = "Admin123";

    String nameStr = "Nhan";
    String secondname = "Kha";
    String lastNameStr = "Le";
    String birthDayStr = "26";
    String birtYearStr = "2002";
    String addressStr = " 73 Tran Dai Nghia";
    String cityStr = "Da Nang";
    String provinceStr = "Da Nang";
    String countryStr = "Viet Nam";
    String postalCodeStr = "000000";
    String phoneNumberStr = " +84000000000";
    String patientRelativeStr = "Khong co";

    public void Login() {
        ome.mySendKeys(ome.usernamePlc, usernameStr);
        ome.mySendKeys(ome.passwordPlc, passwordStr);
        ome.myClick(ome.inpatientWard);
        ome.myClick(ome.loginButton);
    }

    @Test(priority = 1)
    public void patientRegistration() {
        Login();
        ome.myClick(ome.registerAPatient);
        ome.mySendKeys(ome.givenNamePlc, nameStr);
        ome.mySendKeys(ome.middleNamePlc, secondname);
        ome.mySendKeys(ome.familyNamePlc, lastNameStr);
        ome.myClick(ome.nextButton);

        Select select = new Select(ome.genderSelect);
        select.selectByIndex(0);
        ome.myClick(ome.nextButton);

        ome.mySendKeys(ome.birthDay, birthDayStr);
        select = new Select(ome.birthMonthSelect);
        select.selectByVisibleText("August");
        ome.mySendKeys(ome.birthYear, birtYearStr);
        ome.myClick(ome.nextButton);

        ome.mySendKeys(ome.address1, addressStr);
        ome.mySendKeys(ome.cityVillage, cityStr);
        ome.mySendKeys(ome.stateProvince, provinceStr);
        ome.mySendKeys(ome.country, countryStr);
        ome.mySendKeys(ome.postalCode, postalCodeStr);
        ome.myClick(ome.nextButton);

        ome.mySendKeys(ome.phoneNumber, phoneNumberStr);
        ome.myClick(ome.nextButton);

        select = new Select(ome.relationshipTypeSelect);
        select.selectByVisibleText("Parent");

        ome.mySendKeys(ome.personName, patientRelativeStr);
        ome.myClick(ome.nextButton);
        ome.myClick(ome.confirmButton);

        wait.until(ExpectedConditions.visibilityOf(ome.patientID));
        Assert.assertTrue(ome.patientID.isDisplayed());
    }

    // Test case 1: Valid patient registration
    @Test(priority = 3)
    public void testValidPatientRegistration() {
        Login();
        ome.myClick(ome.registerAPatient);
        ome.mySendKeys(ome.givenNamePlc, "Le");
        ome.mySendKeys(ome.middleNamePlc, "Kha");
        ome.mySendKeys(ome.familyNamePlc, "Nhan");
        ome.myClick(ome.nextButton);

        Select select = new Select(ome.genderSelect);
        select.selectByVisibleText("Female");
        ome.myClick(ome.nextButton);

        ome.mySendKeys(ome.birthDay, "26");
        select = new Select(ome.birthMonthSelect);
        select.selectByVisibleText("September");
        ome.mySendKeys(ome.birthYear, "2002");
        ome.myClick(ome.nextButton);

        ome.mySendKeys(ome.address1, "73 Tran Dai Nghia");
        ome.mySendKeys(ome.address2, "37 Tran Dai Nghia");
        ome.mySendKeys(ome.cityVillage, "Da Nang");
        ome.mySendKeys(ome.stateProvince, "Da Nang");
        ome.mySendKeys(ome.country, "Viet Nam");
        ome.mySendKeys(ome.postalCode, "000000");
        ome.myClick(ome.nextButton);

        ome.mySendKeys(ome.phoneNumber, "+84000000000");
        ome.myClick(ome.nextButton);

        select = new Select(ome.relationshipTypeSelect);
        select.selectByVisibleText("Parent");

        ome.mySendKeys(ome.personName, "Khong co");
        ome.myClick(ome.nextButton);
        ome.myClick(ome.confirmButton);

        wait.until(ExpectedConditions.visibilityOf(ome.patientID));
        Assert.assertTrue(ome.patientID.isDisplayed());
    }

    // Test case 2: Invalid day value (non-numeric day)
    @Test(priority = 4)
    public void testInvalidDayValue() {
        Login();
        ome.myClick(ome.registerAPatient);
        ome.mySendKeys(ome.givenNamePlc, "Le");
        ome.mySendKeys(ome.familyNamePlc, "Nhan");
        ome.myClick(ome.nextButton);

        Select select = new Select(ome.genderSelect);
        select.selectByVisibleText("Female");
        ome.myClick(ome.nextButton);

        ome.mySendKeys(ome.birthDay, "a"); // Day không hợp lệ
        select = new Select(ome.birthMonthSelect);
        select.selectByVisibleText("September");
        ome.mySendKeys(ome.birthYear, "2002");
        ome.myClick(ome.nextButton);

        // Kiểm tra thông báo lỗi
        Assert.assertTrue(ome.errorMessage.isDisplayed());
    }

    // Test case 3: Invalid day value (day = 0)
    @Test(priority = 5)
    public void testDayZero() {
        Login();
        ome.myClick(ome.registerAPatient);
        ome.mySendKeys(ome.givenNamePlc, "Le");
        ome.mySendKeys(ome.familyNamePlc, "Nhan");
        ome.myClick(ome.nextButton);

        Select select = new Select(ome.genderSelect);
        select.selectByVisibleText("Female");
        ome.myClick(ome.nextButton);

        ome.mySendKeys(ome.birthDay, "0"); // Day = 0
        select = new Select(ome.birthMonthSelect);
        select.selectByVisibleText("September");
        ome.mySendKeys(ome.birthYear, "2002");
        ome.myClick(ome.nextButton);

        // Kiểm tra thông báo lỗi
        Assert.assertTrue(ome.errorMessage.isDisplayed());
    }

    // Test case 4: Invalid day value (day = 32)
    @Test(priority = 6)
    public void testDayThirtyTwo() {
        Login();
        ome.myClick(ome.registerAPatient);
        ome.mySendKeys(ome.givenNamePlc, "Le");
        ome.mySendKeys(ome.familyNamePlc, "Nhan");
        ome.myClick(ome.nextButton);

        Select select = new Select(ome.genderSelect);
        select.selectByVisibleText("Female");
        ome.myClick(ome.nextButton);

        ome.mySendKeys(ome.birthDay, "32"); // Day = 32
        select = new Select(ome.birthMonthSelect);
        select.selectByVisibleText("September");
        ome.mySendKeys(ome.birthYear, "2002");
        ome.myClick(ome.nextButton);

        // Kiểm tra thông báo lỗi
        Assert.assertTrue(ome.errorMessage.isDisplayed());
    }

    // Test case 5: Invalid day in month (Day = 31 and month = April)
    @Test(priority = 7)
    public void testInvalidDayInMonth() {
        Login();
        ome.myClick(ome.registerAPatient);
        ome.mySendKeys(ome.givenNamePlc, "Le");
        ome.mySendKeys(ome.familyNamePlc, "Nhan");
        ome.myClick(ome.nextButton);

        Select select = new Select(ome.genderSelect);
        select.selectByVisibleText("Female");
        ome.myClick(ome.nextButton);

        ome.mySendKeys(ome.birthDay, "31"); // Day = 31
        select = new Select(ome.birthMonthSelect);
        select.selectByVisibleText("April"); // April has only 30 days
        ome.mySendKeys(ome.birthYear, "2002");
        ome.myClick(ome.nextButton);

        // Kiểm tra thông báo lỗi
        Assert.assertTrue(ome.errorMessage.isDisplayed());
    }

    // Test case 6: Invalid February day (Day = 31 and month = February)
    @Test(priority = 8)
    public void testInvalidFebruaryDay() {
        Login();
        ome.myClick(ome.registerAPatient);
        ome.mySendKeys(ome.givenNamePlc, "Le");
        ome.mySendKeys(ome.familyNamePlc, "Nhan");
        ome.myClick(ome.nextButton);

        Select select = new Select(ome.genderSelect);
        select.selectByVisibleText("Female");
        ome.myClick(ome.nextButton);

        ome.mySendKeys(ome.birthDay, "31"); // Day = 31
        select = new Select(ome.birthMonthSelect);
        select.selectByVisibleText("February"); // February has at most 29 days
        ome.mySendKeys(ome.birthYear, "2002");
        ome.myClick(ome.nextButton);

        // Kiểm tra thông báo lỗi
        Assert.assertTrue(ome.errorMessage.isDisplayed());
    }

    // Test case 7: Year too old (Year = 1900)
    @Test(priority = 9)
    public void testYearTooOld() {
        Login();
        ome.myClick(ome.registerAPatient);
        ome.mySendKeys(ome.givenNamePlc, "Le");
        ome.mySendKeys(ome.familyNamePlc, "Nhan");
        ome.myClick(ome.nextButton);

        Select select = new Select(ome.genderSelect);
        select.selectByVisibleText("Female");
        ome.myClick(ome.nextButton);

        ome.mySendKeys(ome.birthDay, "26");
        select = new Select(ome.birthMonthSelect);
        select.selectByVisibleText("August");
        ome.mySendKeys(ome.birthYear, "1900"); // Year too old
        ome.myClick(ome.nextButton);

        // Kiểm tra thông báo lỗi
        Assert.assertTrue(ome.errorMessage.isDisplayed());
    }
}
