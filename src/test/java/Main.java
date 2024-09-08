import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DriverManager.setupDriver();
        DriverManager.navigateToUrl("https://www.jollytur.com/");
        DriverManager.maximizeWindow();

        Utils.waitForSeconds(5);

        // Kampanya Popup'u kapatma
        PopupHandler.closeCampaignPopup();

        Utils.waitForSeconds(2);

        // Reklam Popup'u kapatma
        PopupHandler.closeAdvertPopup();

        LoginPage.login("basolatakan8@gmail.com", "Ab123456!!");

        //Utils.waitForSeconds(10);
        //DriverManager.quitDriver();
    }
}
