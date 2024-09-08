import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PopupHandler {

    public static void closeCampaignPopup() {
        List<WebElement> campaignPopup = DriverManager.getDriver().findElements(By.xpath("//div[@class='vl-notif-msg']"));
        if (!campaignPopup.isEmpty()) {
            WebElement campaignCloseButton = DriverManager.getDriver().findElement(By.xpath("//button[@id='web_push_hayir']"));
            campaignCloseButton.click();
            System.out.println("Kampanya Bildirimi Kapatıldı.");
        } else {
            System.out.println("Kampanya Bildirim Sayfası Görülmedi.");
        }
    }

    public static void closeAdvertPopup() {
        List<WebElement> advertImage = DriverManager.getDriver().findElements(By.xpath("//img[@alt='vl-popup-image']"));
        if (!advertImage.isEmpty()) {
            Utils.clickButton("//span[@class='vl-popup-close']");
            System.out.println("Reklam Popup Kapatıldı.");
        } else {
            System.out.println("Reklam görseli bulunamadı.");
        }
    }
    //Kontrol edilecek
    public static void cookiePolicy(){
        List<WebElement> cookiePolicyText = DriverManager.getDriver().findElements(By.xpath("//div[@data-name='Accept Button']"));
        if (!cookiePolicyText.isEmpty()) {
            Utils.clickButton("//div[@data-name='Accept Button']");
            System.out.println("Çerez Politikaları Popupı Kapatıldı.");
        } else {
            System.out.println("Çerez Politikaları Popupı bulunamadı.");
        }
    }
}
