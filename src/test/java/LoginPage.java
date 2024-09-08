import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    public static void login(String email, String password) {
        try {
            // Giriş butonuna tıklıyoruz
            Utils.clickButton("//a[@title='GİRİŞ YAP']");

            // E-posta ve şifre alanlarını dolduruyoruz
            Utils.setInputField(By.xpath("//input[@placeholder='E-Posta Adresinizi Giriniz']"), email);
            Utils.setInputField(By.xpath("//input[@placeholder='Şifrenizi Giriniz']"), password);

            // reCAPTCHA kontrolü yapılacak
            List<WebElement> recaptchaFrames = DriverManager.getDriver().findElements(By.xpath("//iframe[@title='reCAPTCHA']"));

            if (!recaptchaFrames.isEmpty()) {
                // İframe'e geçiş yapıyoruz
                System.out.println("reCAPTCHA bulundu, işlem yapılıyor.");
                DriverManager.getDriver().switchTo().frame(recaptchaFrames.get(0));

                // reCAPTCHA checkbox'ının tıklanabilir olmasını bekliyoruz
                WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));
                WebElement recaptchaCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='recaptcha-checkbox-border']")));
                recaptchaCheckbox.click();

                // Tekrar ana sayfaya dönüyoruz (iframe'den çıkıyoruz)
                DriverManager.getDriver().switchTo().defaultContent();

                // Giriş yap butonuna tıklıyoruz
                Utils.clickButton("//button[@class='button full third']");
                System.out.println("reCAPTCHA doğrulandı ve giriş yap butonuna tıklandı.");
            } else {
                // Eğer reCAPTCHA görünmüyorsa doğrudan giriş yap butonuna tıklıyoruz
                System.out.println("reCAPTCHA görünmedi, giriş yap butonuna tıklanıyor.");
                Utils.clickButton("//button[@class='button full third']");
            }

        } catch (Exception e) {
            throw new RuntimeException("Giriş işlemi sırasında bir hata oluştu: " + e.getMessage(), e);
        }
    }
}
