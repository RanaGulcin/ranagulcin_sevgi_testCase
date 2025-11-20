package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.HomePage;
import pages.LeverFormPage;
import pages.QAJobPage;

public class QATest extends BaseTest {

    @Test
    public void verifyTestSteps(){
        HomePage homePage = new HomePage();
        CareersPage careersPage = new CareersPage();
        QAJobPage qaJobPage = new QAJobPage();
        LeverFormPage leverFormPage = new LeverFormPage();


        //1- Visit https://useinsider.com/ and check Insider home page is opened or not
        homePage.openHomePage();
        Assert.assertTrue(homePage.isCorrectHomePage(),"URL is correct.");
        homePage.closeCookieIfPresent();
        homePage.clickCompanyMenu();


        //2- Select the “Company” menu in the navigation bar, select “Careers” and check Career page, its Locations, Teams, and Life at Insider blocks are open or not
        careersPage.openCareersPage();
        Assert.assertTrue(careersPage.isteamsButtonVisible(),"Team block is visible.");
        Assert.assertTrue(careersPage.islocationHeaderVisible(),"Location block is visible");
        Assert.assertTrue(careersPage.isLifeAtInsiderVisible(),"Life at Insider block is visible");


        //3- Go to https://useinsider.com/careers/quality-assurance/, click “See all QA jobs”, filter jobs by Location: “Istanbul, Turkey”, and Department: “Quality Assurance”, check the presence of the jobs list
        qaJobPage.openQAPage();
        qaJobPage.clickSeeAllQAJobs();
        qaJobPage.filterLocation("Istanbul, Turkey");
        qaJobPage.filterDepartment();

        //4- Check that all jobs’ Position contains “Quality Assurance”, Department contains “Quality Assurance”, and Location contains “Istanbul, Turkey”
        qaJobPage.getJobList().forEach(job -> {
            Assert.assertTrue(job.getText().contains("Istanbul, Turkey"));
            Assert.assertTrue(job.getText().contains("Quality Assurance"));
        });

        //5- Click the “View Role” button and check that this action redirects us to the Lever Application form page
        qaJobPage.clickFirstViewRole();
        Assert.assertTrue(leverFormPage.isCorrectLeverUrl(),"This page is Lever Form Page.");











    }
}
