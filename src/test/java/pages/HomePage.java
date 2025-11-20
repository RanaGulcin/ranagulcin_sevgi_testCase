package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {


    @FindBy(xpath = "(//a[@id='navbarDropdownMenuLink'])[5]")
    private WebElement companyMenuButton;

    @FindBy(xpath = "//a[@id='wt-cli-accept-all-btn']")
    private WebElement cookieAcceptBtn;


    public void openHomePage() {
        driver.get("homeUrl");

        String currentUrl = driver.getCurrentUrl();
        if ("homeUrl"== currentUrl){
            System.out.println("Insider ana sayfasına gidildi.");
        }
    }


    public void closeCookieIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(cookieAcceptBtn));
            cookieAcceptBtn.click();
            System.out.println("Cookie popup kapatıldı.");
        } catch (Exception e) {
            System.out.println("Cookie popup görünmedi, test devam ediyor.");
        }
    }

    public void clickCompanyMenu() {
        companyMenuButton.click();
    }


}
