package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Tools extends BaseDriver {
    public static void wait(int sn) {

        try {
            Thread.sleep(sn * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void SuccessMessageValidation() {
        WebElement successText = driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]"));

        Assert.assertTrue(successText.getText().toLowerCase().contains("success"));
    }

    public static void JSClick(WebElement e) {
        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.driver;
        js.executeScript("arguments[0].click();", e);
    }

    public static int randomGenerator(int range) {
        return (int) (Math.random() * range);
    }

    public static boolean ListContainsString(List<WebElement> list, String search) {
        boolean isFound = false;
        for (WebElement e : list) {
            if (e.getText().equalsIgnoreCase(search))
                isFound = true;
        }

        return isFound;
    }

    public static boolean compareLists(List<WebElement> list1, List<String> list2) {
        // Check if the lists are of equal size
        if (list1.size() != list2.size()) {
            return false;
        }

        // Iterate through the elements of both lists and compare them
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).getText().equals(list2.get(i))) {
                return false;
            }
        }

        return true;
    }

}
