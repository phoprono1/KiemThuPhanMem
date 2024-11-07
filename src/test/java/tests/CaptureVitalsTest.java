package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CaptureVitalFormPage;
import pages.CaptureVitalMenuPage;

public class CaptureVitalsTest extends BaseTest {
    @Test
    @DisplayName("CV_001 - Verify Admin can capture vitals for a patient")
    public void testFullVitals(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.inputFocusedField("170"); captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("65");  captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter(); //skips BMI page because no input
        captureVitalFormPage.inputFocusedField("37");  captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("85");  captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("20");  captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("120"); captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("80");  captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("99");  captureVitalFormPage.pressEnter();
        captureVitalFormPage.clickSaveButton();
        String alertText = captureVitalFormPage.getToastField();
        Assertions.assertTrue(alertText.contains("Entered Vitals for"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_002 - Verify Admin can cancel capture vitals for a patient")
    public void testCancelVitals(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickCancelButton();
        String url = captureVitalFormPage.getURLCurrent();
        Assertions.assertEquals("https://demo.openmrs.org/openmrs/coreapps/findpatient/findPatient.page?app=referenceapplication.vitals&", url, "Testcase failed");
    }

    @Test
    @DisplayName("CV_003 - Verify Height field cannot be below minimum")
    public void testHeightBelowMinimum(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.inputFocusedField("-1"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Minimum: 10"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_004 - Verify Height field cannot be above maximum")
    public void testHeightAboveMaximum(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.inputFocusedField("280"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Maximum: 272"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_005 - Verify Height field must be number")
    public void testHeightNotNumber(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.inputFocusedField("a"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Must be a number"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_006 - Verify Weight field cannot be below minimum")
    public void testWeightBelowMinimum(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("-1"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Minimum: 0"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_007 - Verify Weight field cannot be above maximum")
    public void testWeightAboveMaximum(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("255"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Maximum: 250"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_008 - Verify Weight field must be number")
    public void testWeightNotNumber(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("a"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Must be a number"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_009 - Verify BMI is calculated when both Height and Weight is entered")
    public void testYesBMIYesBoth(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.inputFocusedField("170"); captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("65"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getBMIFieldMessage();
        Assertions.assertTrue(alertText.contains("Patient's BMI is"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_010 - Verify BMI is not calculated when only Height is entered")
    public void testNoBMIOnlyHeight(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.inputFocusedField("170"); captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getNoBMIFieldMessage();
        Assertions.assertTrue(alertText.contains("If you record a weight and height, we will calculate the BMI"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_011 - Verify BMI is not calculated when only Weight is entered")
    public void testNoBMIOnlyWeight(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("65"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getNoBMIFieldMessage();
        Assertions.assertTrue(alertText.contains("If you record a weight and height, we will calculate the BMI"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_012 - Test BMI is not displayed when neither Height nor Weight is entered")
    public void testNoBMINoFields(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter(); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getNoBMIFieldMessage();
        Assertions.assertTrue(alertText.contains("If you record a weight and height, we will calculate the BMI"), "Testcase failed");
    }


    @Test
    @DisplayName("CV_013 - Verify Temperature field cannot be below minimum")
    public void testTempBelowMinimum(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("-1"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Minimum: 25"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_014 - Verify Temperature field cannot be below minimum")
    public void testTempAboveMaximum(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("50"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Maximum: 43"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_015 - Verify Temperature field must be number")
    public void testTempNotNumber(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("a"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
            Assertions.assertTrue(alertText.contains("Must be a number"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_016 - Verify Pulse field cannot be below minimum")
    public void testPulseBelowMinimum(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("-1"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Minimum: 0"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_017 - Verify Pulse field cannot be below minimum")
    public void testPulseAboveMaximum(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("250"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Maximum: 230"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_018 - Verify Pulse field must be number")
    public void testPulseNotNumber(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("a"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Must be a whole number"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_019 - Verify Respiratory rate field cannot be below minimum")
    public void testRespiratoryBelowMinimum(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("-1"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Minimum: 0"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_020 - Verify Respiratory rate field cannot be below minimum")
    public void testRespiratoryAboveMaximum(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("100"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Maximum: 99"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_021 - Verify Respiratory rate field must be number")
    public void testRespiratoryNotNumber(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("a"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Must be a whole number"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_022 - Verify Upper Blood Pressure field cannot be below minimum")
    public void testSystolicBPBelowMinimum(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("-1"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Minimum: 50"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_023 - Verify Upper Blood Pressure field cannot be above maximum")
    public void testSystolicBPAboveMaximum(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("300"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Maximum: 250"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_024 - Verify Upper Blood Pressure field must be number")
    public void testSystolicBPNotNumber(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("a"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Must be a whole number"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_025 - Verify Lower Blood Pressure field cannot be below minimum")
    public void testDiastolicBPBelowMinimum(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("-1"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Minimum: 30"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_026 - Verify Lower Blood Pressure field cannot be below minimum")
    public void testDiastolicBPAboveMaximum(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("300"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Maximum: 150"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_027 - Verify Lower Blood Pressure field must be number")
    public void testDiastolicBPNotNumber(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("a"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Must be a whole number"), "Testcase failed");
    }

    //This testcase is guaranteed to fail because there is no check in place for Systolic BP
    //to be greater than Diastolic BP
    @Test
    @DisplayName("CV_028 - Verify Upper Blood Pressure must be higher than Lower Blood Pressure")
    public void testSystolicGreaterThanDiastolicBPNotNumber(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("80"); captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("120"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Systolic blood pressure must be greater than Diastolic blood pressure"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_029 - Verify Arterial blood oxygen saturation (pulse oximeter) field cannot be below minimum")
    public void testBloodOxygenBelowMinimum(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("-1"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Minimum: 0"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_030 - Verify Arterial blood oxygen saturation (pulse oximeter) field cannot be below minimum")
    public void testBloodOxygenAboveMaximum(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("110"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Maximum: 100"), "Testcase failed");
    }

    @Test
    @DisplayName("CV_011 - Verify Arterial blood oxygen saturation (pulse oximeter) field must be number")
    public void testBloodOxygenNotNumber(){
        CaptureVitalMenuPage captureVitalMenuPage = dashboardPage.clickCaptureVitals();
        CaptureVitalFormPage captureVitalFormPage = captureVitalMenuPage.captureVitals();
        captureVitalFormPage.clickContinueButton();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.pressEnter();
        captureVitalFormPage.inputFocusedField("a"); captureVitalFormPage.pressEnter();
        String alertText = captureVitalFormPage.getErrorMessage();
        Assertions.assertTrue(alertText.contains("Must be a whole number"), "Testcase failed");
    }
}
