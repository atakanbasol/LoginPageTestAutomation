import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    @BeforeMethod
    public void setUp() {
        // WebDriver'ı başlatır ve sayfayı yükler
        DriverManager.setupDriver();
        DriverManager.navigateToUrl("https://www.jollytur.com/");
        DriverManager.maximizeWindow();
    }

    @Test
    public void testLogin() {
        // Biraz bekle (dinamik yüklemeler için)
        Utils.waitForSeconds(5);

        // Kampanya pop-up'ını kapatır
        PopupHandler.closeCampaignPopup();

        Utils.waitForSeconds(2);

        // Reklam pop-up'ını kapatır
        PopupHandler.closeAdvertPopup();

        Utils.waitForSeconds(2);

        PopupHandler.cookiePolicy();

        Utils.waitForSeconds(2);

        // Giriş işlemi
        LoginPage.login("basolatakan8@gmail.com", "Ab123456!!");

        // Testin sonunda biraz bekle
        Utils.waitForSeconds(10);
    }

    @AfterMethod
    public void tearDown() {
        // Tarayıcıyı kapat
        DriverManager.quitDriver();
    }
}
