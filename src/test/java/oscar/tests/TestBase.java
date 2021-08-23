package oscar.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import oscar.pages.PageBase;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;

    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeMethod(alwaysRun = true)
    public void startTest(Method method, Object[] p) {
        logger.info("Start test: " + method.getName());
        if(p.length!= 0) {
            logger.info("--> With data: " + Arrays.asList(p));
        }
    }


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://selenium1py.pythonanywhere.com/en-gb/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(enabled = true)
    public void tearDown(ITestResult result) {

        if(result.isSuccess()) {
            logger.info("Test result: PASSED");
        }else {
            logger.error("Test result: FAILED" + "\n" + new PageBase(driver).takeScreenShotWithScrollDown());
        }
        logger.info("Stop test: "+ result.getTestName());
        logger.info("*****************************");

        driver.quit();
    }

}
