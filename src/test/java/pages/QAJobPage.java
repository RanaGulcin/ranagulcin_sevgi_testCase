package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class QAJobPage extends BasePage {


    @FindBy(xpath = "//a[@href='https://useinsider.com/careers/open-positions/?department=qualityassurance']")
    private WebElement seeAllQAJobsButton;

    @FindBy(xpath = "//span[@id='select2-filter-by-location-container']")
    private WebElement locationDropdown;

    @FindBy(xpath = "//span[@id='select2-filter-by-department-container']")
    private WebElement departmentDropdown;

    @FindBy(css = "div.position-list div")
    private List<WebElement> jobList;


    private final By viewRoleButton = By.cssSelector(".btn.btn-navy.rounded");

    public void openQAPage(){
        driver.get("qaJobsUrl");
    }

    public void clickSeeAllQAJobs() {
        seeAllQAJobsButton.click();
    }

    public void filterLocation(String location) {
        locationDropdown.click();
        driver.findElement(By.xpath("//li[contains(@class,'select2-results__option') and text()='" + location + "']")).click();
    }

    public void filterDepartment(String department) {
        departmentDropdown.click();
        driver.findElement(By.xpath("//li[contains(@class,'select2-results__option') and text()='" + department + "']")).click();
    }

    public List<WebElement> getJobList() {
        return jobList;
    }

    public void clickFirstViewRole() {
        jobList.get(0).findElement(viewRoleButton).click();
    }



}
