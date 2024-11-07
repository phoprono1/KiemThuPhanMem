package registerpatient;


import base.BaseTest;
import org.example.pages.SecureAreaPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegisterPatientFunction extends BaseTest {

    @Test
    @DisplayName("RP_001_Verify register a patient successful when all fields are valid without Unidentified Patient checkbox")
    public void testRegisterSuccessfull(){
        SecureAreaPage secureAreaPage = loginPage.doSuccessfulLogin();
        registerPage.register();
        registerPage.setGivenName("Nhuan");
        registerPage.setMiddleName("Pho");
        registerPage.setFamilyName("Ngô");
        registerPage.clickNext();
        registerPage.setGender("Female");
        registerPage.clickNext();
        registerPage.setBirthdateDay("11");
        registerPage.setBirthdateMonth("September");
        registerPage.setBirthdateYear("2003");
        registerPage.clickNext();
        registerPage.setAddress1("22 Chùa Láng");
        registerPage.setAddress2("23 Chùa Láng");
        registerPage.setCityVillage("Hà Nội");
        registerPage.setStateProvince("Pho Phòng");
        registerPage.setCountry("Việt Nam");
        registerPage.setPostalCode("000000");
        registerPage.clickNext();
        registerPage.setPhoneNumber("+84000000000");
        registerPage.clickNext();
        registerPage.setSelectRelationship();
        registerPage.clickNext();
        registerPage.clickConfirm();
        String arlettext = registerPage.getToastField();
        Assertions.assertTrue(arlettext.contains("Created Patient Record"), "Test case fail!");
    }

    @Test
    @DisplayName("RP_002_Verify register a patient failed without entering Given Name field")
    public void testRegisterGivenNameFail(){
        SecureAreaPage secureAreaPage = loginPage.doSuccessfulLogin();
        registerPage.register();
        registerPage.setGivenName("");
        registerPage.clickNext();
        String arlettext = registerPage.getErrorMessage();
        Assertions.assertTrue(arlettext.contains("Required"), "Test case fail!");
    }

    @Test
    @DisplayName("RP_003_Verify register a patient failed without entering Family Name field")
    public void testRegisterFamilyNameFail(){
        SecureAreaPage secureAreaPage = loginPage.doSuccessfulLogin();
        registerPage.register();
        registerPage.setGivenName("Nhuan");
        registerPage.setMiddleName("");
        registerPage.setFamilyName("");
        registerPage.clickNext();
        String arlettext = registerPage.getErrorMessage();
        Assertions.assertTrue(arlettext.contains("Required"), "Test case fail!");
    }

    @Test
    @DisplayName("RP_004_Verify register a patient failed without selecting Gender field")
    public void testRegisterGenderFail(){
        SecureAreaPage secureAreaPage = loginPage.doSuccessfulLogin();
        registerPage.register();
        registerPage.setGivenName("Nhuan");
        registerPage.setMiddleName("");
        registerPage.setFamilyName("Ngô");
        registerPage.clickNext();
        registerPage.setGender("");
        registerPage.clickNext();
        String arlettext = registerPage.getErrorMessage();
        Assertions.assertTrue(arlettext.contains("Required"), "Test case fail!");
    }

    @Test
    @DisplayName("RP_005_Verify register a patient failed without inputting BirthDateDay field")
    public void testRegisterBirthDateDayFail(){
        SecureAreaPage secureAreaPage = loginPage.doSuccessfulLogin();
        registerPage.register();
        registerPage.setGivenName("Ngô");
        registerPage.setMiddleName("");
        registerPage.setFamilyName("Nhuan");
        registerPage.clickNext();
        registerPage.setGender("Female");
        registerPage.clickNext();
        registerPage.setBirthdateDay("");
        registerPage.clickNext();
        String arlettext = registerPage.getErrorMessage();
        Assertions.assertTrue(arlettext.contains("Required"), "Test case fail!");
    }

    @Test
    @DisplayName("RP_006_Verify register a patient failed due to malformed  BirthDateDay field")
    public void testRegisterBirthDateDayFail2(){
        SecureAreaPage secureAreaPage = loginPage.doSuccessfulLogin();
        registerPage.register();
        registerPage.setGivenName("Ngô");
        registerPage.setMiddleName("");
        registerPage.setFamilyName("Nhuan");
        registerPage.clickNext();
        registerPage.setGender("Female");
        registerPage.clickNext();
        registerPage.setBirthdateDay("a");
        registerPage.clickNext();
        String arlettext = registerPage.getErrorMessage();
        Assertions.assertTrue(arlettext.contains("Must be a number"), "Test case fail!");
    }

    @Test
    @DisplayName("RP_007_Verify register a patient failed by inputting BirthDateDay field < 0")
    public void testRegisterBirthDateDayFail3(){
        SecureAreaPage secureAreaPage = loginPage.doSuccessfulLogin();
        registerPage.register();
        registerPage.setGivenName("Ngô");
        registerPage.setMiddleName("");
        registerPage.setFamilyName("Nhuan");
        registerPage.clickNext();
        registerPage.setGender("Female");
        registerPage.clickNext();
        registerPage.setBirthdateDay("0");
        registerPage.clickNext();
        String arlettext = registerPage.getErrorMessage();
        Assertions.assertTrue(arlettext.contains("Minimum: 1"), "Test case fail!");
    }

    @Test
    @DisplayName("RP_008_Verify register a patient failed by inputting BirthDateDay field > 31")
    public void testRegisterBirthDateDayFail4(){
        SecureAreaPage secureAreaPage = loginPage.doSuccessfulLogin();
        registerPage.register();
        registerPage.setGivenName("Ngô");
        registerPage.setMiddleName("");
        registerPage.setFamilyName("Nhuan");
        registerPage.clickNext();
        registerPage.setGender("Female");
        registerPage.clickNext();
        registerPage.setBirthdateDay("32");
        registerPage.clickNext();
        String arlettext = registerPage.getErrorMessage();
        Assertions.assertTrue(arlettext.contains("Maximum: 31"), "Test case fail!");
    }

    // Fail - Message error: You need to inform a valid date
    @Test
    @DisplayName("RP_009_Verify register a patient failed without selectting BirthDateMonth field")
    public void testRegisterBirthDateMonthFail(){
        SecureAreaPage secureAreaPage = loginPage.doSuccessfulLogin();
        registerPage.register();
        registerPage.setGivenName("Ngô");
        registerPage.setMiddleName("");
        registerPage.setFamilyName("Nhuan");
        registerPage.clickNext();
        registerPage.setGender("Female");
        registerPage.clickNext();
        registerPage.setBirthdateDay("11");
        registerPage.setBirthdateMonth("");
//        registerPage.setBirthdateYear("1992");
        registerPage.clickNext();
        String arlettext = registerPage.getErrorMessage();
        Assertions.assertTrue(arlettext.contains("Required"), "Test case fail!");
    }

    @Test
    @DisplayName("RP_010_Verify register a patient failed without inputting BirthDateYear field")
    public void testRegisterBirthDateYearFail(){
        SecureAreaPage secureAreaPage = loginPage.doSuccessfulLogin();
        registerPage.register();
        registerPage.setGivenName("Ngô");
        registerPage.setMiddleName("");
        registerPage.setFamilyName("Nhuan");
        registerPage.clickNext();
        registerPage.setGender("Female");
        registerPage.clickNext();
        registerPage.setBirthdateDay("11");
        registerPage.setBirthdateMonth("September");
        registerPage.setBirthdateYear("");
        registerPage.clickNext();
        String arlettext = registerPage.getErrorMessage();
        Assertions.assertTrue(arlettext.contains("You need to inform a valid date"), "Test case fail!");
    }

    @Test
    @DisplayName("RP_011_Verify register a patient failed by entering the 31th at September")
    public void testRegisterBirthDateYearFail2(){
        SecureAreaPage secureAreaPage = loginPage.doSuccessfulLogin();
        registerPage.register();
        registerPage.setGivenName("Ngô");
        registerPage.setMiddleName("");
        registerPage.setFamilyName("Nhuan");
        registerPage.clickNext();
        registerPage.setGender("Female");
        registerPage.clickNext();
        registerPage.setBirthdateDay("31");
        registerPage.setBirthdateMonth("September");
        registerPage.setBirthdateYear("2003");
        registerPage.clickNext();
        String arlettext = registerPage.getErrorMessage();
        Assertions.assertTrue(arlettext.contains("There are only 30 days in the selected month"), "Test case fail!");
    }

    @Test
    @DisplayName("RP_012_Verify register a patient failed by entering the 31th at February")
    public void testRegisterBirthDateYearFail3(){
        SecureAreaPage secureAreaPage = loginPage.doSuccessfulLogin();
        registerPage.register();
        registerPage.setGivenName("Ngô");
        registerPage.setMiddleName("");
        registerPage.setFamilyName("Nhuan");
        registerPage.clickNext();
        registerPage.setGender("Female");
        registerPage.clickNext();
        registerPage.setBirthdateDay("30");
        registerPage.setBirthdateMonth("February");
        registerPage.setBirthdateYear("2003");
        registerPage.clickNext();
        String arlettext = registerPage.getErrorMessage();
        Assertions.assertTrue(arlettext.contains("There are only 28 days in february for the specified year"), "Test case fail!");
    }

    @Test
    @DisplayName("RP_013_Verify register a patient failed by inputting BirthDateYear field < 1903")
    public void testRegisterBirthDateYearFail4(){
        SecureAreaPage secureAreaPage = loginPage.doSuccessfulLogin();
        registerPage.register();
        registerPage.setGivenName("Ngô");
        registerPage.setMiddleName("");
        registerPage.setFamilyName("Nhuan");
        registerPage.clickNext();
        registerPage.setGender("Female");
        registerPage.clickNext();
        registerPage.setBirthdateDay("11");
        registerPage.setBirthdateMonth("September");
        registerPage.setBirthdateYear("1900");
        registerPage.clickNext();
        String arlettext = registerPage.getErrorMessage();
        Assertions.assertTrue(arlettext.contains("Minimum: 1903"), "Test case fail!");
    }

    @Test
    @DisplayName("RP_014_Verify register a patient failed by inputting BirthDateYear field > 2023")
    public void testRegisterBirthDateYearFail5(){
        SecureAreaPage secureAreaPage = loginPage.doSuccessfulLogin();
        registerPage.register();
        registerPage.setGivenName("Ngô");
        registerPage.setMiddleName("");
        registerPage.setFamilyName("Nhuan");
        registerPage.clickNext();
        registerPage.setGender("Female");
        registerPage.clickNext();
        registerPage.setBirthdateDay("11");
        registerPage.setBirthdateMonth("September");
        registerPage.setBirthdateYear("2024");
        registerPage.clickNext();
        String arlettext = registerPage.getErrorMessage();
        Assertions.assertTrue(arlettext.contains("Maximum: 2023"), "Test case fail!");
    }

    @Test
    @DisplayName("RP_015_Verify register a patient failed without inputting any field in left sidebar tab Address")
    public void testRegisterAddress1Fail(){
        SecureAreaPage secureAreaPage = loginPage.doSuccessfulLogin();
        registerPage.register();
        registerPage.setGivenName("Ngô");
        registerPage.setMiddleName("");
        registerPage.setFamilyName("Nhuan");
        registerPage.clickNext();
        registerPage.setGender("Female");
        registerPage.clickNext();
        registerPage.setBirthdateDay("11");
        registerPage.setBirthdateMonth("September");
        registerPage.setBirthdateYear("2003");
        registerPage.clickNext();
        registerPage.setAddress1("");
        registerPage.clickNext();
        String arlettext = registerPage.getErrorMessage();
        Assertions.assertTrue(arlettext.contains("You need to provide a value for at least one field"), "Test case fail!");
    }

    @Test
    @DisplayName("RP_016_Verify register a patient failed due to malformed PhoneNumber field")
    public void testRegisterPhoneNumber2Fail(){
        SecureAreaPage secureAreaPage = loginPage.doSuccessfulLogin();
        registerPage.register();
        registerPage.setGivenName("Ngô");
        registerPage.setMiddleName("");
        registerPage.setFamilyName("Nhuan");
        registerPage.clickNext();
        registerPage.setGender("Female");
        registerPage.clickNext();
        registerPage.setBirthdateDay("11");
        registerPage.setBirthdateMonth("September");
        registerPage.setBirthdateYear("2003");
        registerPage.clickNext();
        registerPage.setAddress1("22 Chùa Láng");
        registerPage.setAddress2("Linh Đông");
        registerPage.setCityVillage("Vĩnh Bảo");
        registerPage.setStateProvince("Pho Phòng");
        registerPage.setCountry("Việt Nam");
        registerPage.setPostalCode("000000");
        registerPage.clickNext();
        registerPage.setPhoneNumber("*000*000");
        registerPage.clickNext();
        String arlettext = registerPage.getErrorMessage();
        Assertions.assertTrue(arlettext.contains("You need to provide a value for at least one field"), "Test case fail!");
    }

}
