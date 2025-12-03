package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {


    @FindBy(xpath = "(//a[@id='navbarDropdownMenuLink'])[5]")
    private WebElement companyMenuButton;


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
