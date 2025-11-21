package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class QAJobPage extends BasePage {


    @FindBy(xpath = "//a[@href='https://useinsider.com/careers/open-positions/?department=qualityassurance']")
    private WebElement seeAllQAJobsButton;

    @FindBy(xpath = "(//span[@role='presentation'])[1]")
    private WebElement locationDropdown;

    @FindBy(id = "select2-filter-by-department-container")
    private WebElement departmentDropdown;

    @FindBy(css = ".position-list-item")
    private List<WebElement> jobList;


    private final By viewRoleButton = By.cssSelector(".btn.btn-navy.rounded");

    public void openQAPage(){
        driver.get("https://useinsider.com/careers/quality-assurance/");
        System.out.println("Visited the https://useinsider.com/careers/quality-assurance/ ");
    }

    public void clickSeeAllQAJobs() {
        seeAllQAJobsButton.click();
        System.out.println("See All QA Jobs Button is clicked");
    }

    public void filterLocation(String location) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.elementToBeClickable(locationDropdown));

        locationDropdown.click();
        System.out.println("Click on Location Dropdown");

        driver.findElement( By.xpath("//li[contains(@class,'select2-results__option') and text()='" + location + "']")).click();
        System.out.println("Selected Location: " + location);
    }

    public void filterDepartment(String department) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.elementToBeClickable(departmentDropdown));
        departmentDropdown.click();
        System.out.println("Click on Department Dropdown");

        driver.findElement(By.xpath("//li[contains(@class,'select2-results__option') and text()='" + department + "']")).click();
        System.out.println("Selected Department: " + department);
    }

    public List<WebElement> getJobList() {
        return jobList;
    }

    public void clickFirstViewRole() {
        jobList.get(0).findElement(viewRoleButton).click();
    }



}
