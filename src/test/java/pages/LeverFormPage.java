package pages;

import base.BasePage;
import org.openqa.selenium.support.FindBy;

public class LeverFormPage extends BasePage {

    public boolean isCorrectLeverUrl(){
        String leverUrl = driver.getCurrentUrl();
        return leverUrl.startsWith("https://jobs.lever.co/useinsider");
    }
}
