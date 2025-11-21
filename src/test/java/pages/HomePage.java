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
        driver.get("https://useinsider.com/");
        System.out.println("Visited https://useinsider.com/ ");
    }

    public boolean isCorrectHomePage(){
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains("https://useinsider.com/");
    }


    public void clickCompanyMenu() {
        companyMenuButton.click();
        System.out.println("Company Menu Button is clicked.");
    }


}
