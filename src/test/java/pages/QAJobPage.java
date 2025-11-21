package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class QAJobPage extends BasePage {


    @FindBy(xpath = "//a[@href='https://useinsider.com/careers/open-positions/?department=qualityassurance']")
    private WebElement seeAllQAJobsButton;



    // Gizli olan <select> elementinin ID'si
    @FindBy(id = "filter-by-location")
    private WebElement hiddenLocationSelectElement;

    // UI'da tıklanabilir olan element
    @FindBy(id = "select2-filter-by-location-container")
    private WebElement locationDropdown;


    // Gizli olan <select> Department elementinin ID'si
    @FindBy(id = "filter-by-department")
    private WebElement hiddenDepartmentSelectElement;

    // UI'da tıklanabilir olan Department elementi
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Gizli Elementi Bulma ve gizli elementin DOM'da var olmasını bekleme
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("filter-by-location")));

        // Select Sınıfı ile Seçimi Yapma (Selenium Yolu)
        // Select sınıfı, element gizli olsa bile değerini ayarlamayı deneyebilir.
        try {
            Select select = new Select(hiddenLocationSelectElement);
            select.selectByVisibleText(location);
            System.out.println("Selected Location via Select Class: " + location);
        } catch (Exception e) {
            // Eğer Select sınıfı başarısız olursa, JavaScript ile devam
            System.out.println("Select Class failed, switching to JavaScript...");
        }

        // JavaScript ile Seçimi Zorlama ve Select2'yi Tetikleme
        // Select2'nin veriyi algılayıp UI'ı güncellemesi için 'change' olayını tetiklememiz gerek.
        String jsScript = String.format(
                "var select = document.getElementById('filter-by-location');" +
                        "select.value = arguments[0];" + // Değeri ayarla
                        "$(select).trigger('change');",   // jQuery'yi kullanarak Select2'yi tetikle

                // Seçeneğin görünür metni
                location
        );

        // NOT: Yukarıdaki kod, jQuery'nin sayfada yüklü olduğunu varsayar. Insider'ın çoğu sayfasında yüklüdür.

        // Doğrudan değeri ayarlayan JavaScript komutunu çalıştır
        js.executeScript(jsScript, location);
        System.out.println("Selected Location via JavaScript and triggered change: " + location);

    }

    public void filterDepartment(String department) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Gizli Elementin DOM'da Var Olmasını Bekle
        // Bekleme, sayfanın yüklenip filtre elementinin hazır olduğundan emin olmak için önemli
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("filter-by-department")));
        System.out.println("Department Select element is present.");

        // JavaScript ile Değeri Ayarlama ve Select2'yi Tetikleme
        // Not: Select2 genellikle value olarak Option'ın metnini değil, <option> elementinin 'value' özelliğini kullanır.
        // Ancak, metinle denemek daha basittir. Eğer metinle çalışmazsa, doğru 'value' değerini bulmalıyız (örneğin 'qualityassurance').

        // Varsayım: Select2 <select> elementindeki 'value' ile eşleşen 'Quality Assurance' metnini kullanır.

        String jsScript = String.format(
                "var select = document.getElementById('filter-by-department');" +
                        // Select2, genellikle metnin küçük harfli ve boşluksuz halini (slug) value olarak kullanır.
                        // Güvenli olması açısından, doğrudan metni kullanmaya çalışalım.
                        "select.value = arguments[0];" +
                        "$(select).trigger('change');",
                department
        );

        // Değeri doğrudan ayarlayan JavaScript komutunu çalıştır
        js.executeScript(jsScript, department);
        System.out.println("Selected Department via JavaScript: " + department);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public List<WebElement> getJobList() {
        return jobList;
    }

    public void clickFirstViewRole() {
        jobList.get(0).findElement(viewRoleButton).click();
    }



}
