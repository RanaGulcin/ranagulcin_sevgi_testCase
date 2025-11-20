package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPage extends BasePage {

    @FindBy(xpath = "//a[@href='https://useinsider.com/careers/']")
    private WebElement careersMenuButton;

    @FindBy(linkText = "See all teams")
    private WebElement teamsButton;

    @FindBy(xpath = "//h3[normalize-space()='Our Locations']")
    private WebElement locationHeader;

    @FindBy(xpath = "//h2[text()='Life at Insider']")
    private WebElement lifeAtInsiderHeader;



    public void openCareersPage() {
        careersMenuButton.click();
    }

    public boolean isteamsButtonVisible() {
        return teamsButton.isDisplayed();
    }

    public boolean islocationHeaderVisible() {
        return locationHeader.isDisplayed();
    }

    public boolean isLifeAtInsiderVisible() {
        return lifeAtInsiderHeader.isDisplayed();
    }


}
