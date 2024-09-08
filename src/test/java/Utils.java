import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Utils {

    public static void clickButton(String xpath) {
        try {
            WebElement button = DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            button.click();
            System.out.println("Element found and clicked: " + xpath);
        } catch (Exception e) {
            throw new RuntimeException("Elemente tıklanırken bir hata oluştu: " + xpath, e);
        }
    }

    public static void setInputField(By locator, String value) {
        try {
            WebElement element = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.click();
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {
            throw new RuntimeException("Girdi alanına veri girerken bir hata oluştu: " + locator.toString(), e);
        }
    }

    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
