package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.HomePage;
import pages.LeverFormPage;
import pages.QAJobPage;

import java.time.Duration;
import java.util.List;

import static utilties.Driver.driver;

public class QATest extends BaseTest {


    HomePage homePage = new HomePage();
    CareersPage careersPage = new CareersPage();
    QAJobPage qaJobPage = new QAJobPage();
    LeverFormPage leverFormPage = new LeverFormPage();

    @Test(priority = 1)
    public void HomePageTest(){

        //1- Visit https://useinsider.com/ and check Insider home page is opened or not
        homePage.openHomePage();
        Assert.assertTrue(homePage.isCorrectHomePage(),"URL is correct.");
        homePage.closeCookieIfPresent();
        homePage.clickCompanyMenu();

    }

    @Test(dependsOnMethods = "HomePageTest",priority = 2)
    public void CareersPageTest(){

        //2- Select the “Company” menu in the navigation bar, select “Careers” and check Career page, its Locations, Teams, and Life at Insider blocks are open or not
        careersPage.openCareersPage();
        Assert.assertTrue(careersPage.isteamsButtonVisible(),"Team block is visible.");
        Assert.assertTrue(careersPage.islocationHeaderVisible(),"Location block is visible");
        Assert.assertTrue(careersPage.isLifeAtInsiderVisible(),"Life at Insider block is visible");

    }

    @Test(priority = 3)
    public void QAJobPageTest(){
        //3- Go to https://useinsider.com/careers/quality-assurance/, click “See all QA jobs”, filter jobs by Location: “Istanbul, Turkey”, and Department: “Quality Assurance”, check the presence of the jobs list
        qaJobPage.openQAPage();
        homePage.closeCookieIfPresent();
        qaJobPage.clickSeeAllQAJobs();
        qaJobPage.filterLocation("Istanbul, Turkiye");
        qaJobPage.filterDepartment("Quality Assurance");

        //4- Check that all jobs’ Position contains “Quality Assurance”, Department contains “Quality Assurance”, and Location contains “Istanbul, Turkey”
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".position-list-item"), 0));

        List<WebElement> filteredJobs = qaJobPage.getJobList();
        System.out.println("Filtrelenmiş Toplam İş Sayısı: " + filteredJobs.size());

        filteredJobs.forEach(job -> {

            // Alt elementlerin selector'lerinin doğru olduğundan emin olun!
            WebElement departmentElement = job.findElement(By.cssSelector(".position-department"));
            WebElement locationElement = job.findElement(By.cssSelector(".position-location"));

            String department = departmentElement.getText().trim();
            String location = locationElement.getText().trim();

            System.out.println("JOB TEXT = " + job.getText()); // Tüm metni yazdırıp ne geldiğini kontrol edilmesi
            System.out.println("DEPARTMENT = " + department);
            System.out.println("LOCATION   = " + location);

            // Doğrulama (Assertion)
            Assert.assertEquals(department, "Quality Assurance", "Departman QA değil!");
            Assert.assertEquals(location, "Istanbul, Turkiye", "Lokasyon doğru değil!");
        });

    }

    @Test(dependsOnMethods = "QAJobPageTest", priority = 4)
    public void LeverFormPageTest(){
        //5- Click the “View Role” button and check that this action redirects us to the Lever Application form page
        qaJobPage.clickFirstViewRole();
        Assert.assertTrue(leverFormPage.isCorrectLeverUrl(),"This page is Lever Form Page.");
    }
}
