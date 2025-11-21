package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilties.Driver;

import java.time.Duration;
import java.util.Set;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(){
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//a[@id='wt-cli-accept-all-btn']")
    private WebElement cookieAcceptBtn;

    public void closeCookieIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(cookieAcceptBtn));
            cookieAcceptBtn.click();
            System.out.println("Cookie popup closed.");
        } catch (Exception e) {
            System.out.println("Cookie popup is not saw, test is going.");
        }
    }

    public void switchToNewTab() {
        try {
            // Mevcut ana pencerenin kimliğini al
            String originalWindow = driver.getWindowHandle();

            System.out.println("Yeni sekmenin açılması bekleniyor...");
            // Yeni bir pencerenin açılmasını bekle (Pencere sayısı 1'den fazla olmalı)
            wait.until(driver -> driver.getWindowHandles().size() > 1);

            // Tüm açık pencerelerin kimliklerini al
            Set<String> allWindows = driver.getWindowHandles();

            // Ana pencere olmayan diğer pencereyi bul ve ona geç
            for (String windowHandle : allWindows) {
                if (!originalWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    System.out.println("Yeni sekmeye geçiş yapıldı. Yeni Sayfa Başlığı: " + driver.getTitle());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("HATA: Yeni sekmeye geçiş yapılamadı! Detay: " + e.getMessage());
            // Hatayı fırlat ki test burada dursun ve hatayı görelim.
            throw e;
        }
    }


}
