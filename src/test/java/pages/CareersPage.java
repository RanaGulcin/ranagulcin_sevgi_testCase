package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPage extends BasePage {

    @FindBy(xpath = "//a[@href='https://useinsider.com/careers/']")
    private WebElement careersMenuButton;

    @FindBy(xpath = "//section[@id='career-find-our-calling']")
    private WebElement teamsBlock;

    @FindBy(xpath = "//section[@id='career-our-location']")
    private WebElement locationBlock;

    @FindBy(xpath = "//section[@data-id='a8e7b90']")
    private WebElement lifeAtInsiderBlock;



    public void openCareersPage() {
        careersMenuButton.click();
        System.out.println("Careers Menu Button is clicked.");
    }

    public boolean isteamsButtonVisible() {
        return teamsBlock.isDisplayed();
    }

    public boolean islocationHeaderVisible() {
        return locationBlock.isDisplayed();
    }

    public boolean isLifeAtInsiderVisible() {
        return lifeAtInsiderBlock.isDisplayed();
    }


}
