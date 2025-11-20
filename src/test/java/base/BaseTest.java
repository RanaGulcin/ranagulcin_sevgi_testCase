package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilties.Driver;

public class BaseTest {

    @BeforeClass
    public void setup(){
        Driver.getDriver();
    }

    @AfterClass
    public void quit(){
        Driver.quitDriver();
    }
}
