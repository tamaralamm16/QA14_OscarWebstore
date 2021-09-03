package oscar.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
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
    String browser;

    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeMethod(alwaysRun = true)
    public void startTest(Method method, Object[] p) {
        logger.info("Start test: " + method.getName());
        if(p.length!= 0) {
            logger.info("--> With data: " + Arrays.asList(p));
        }
    }


    @BeforeMethod(alwaysRun = false)
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
//        options.addArguments("window-size=1200x800");
//        if(browser.equals(BrowserType.CHROME)) {
//            driver = new ChromeDriver(options);
//        }else if(browser.equals(BrowserType.FIREFOX)) {
//            driver = new FirefoxDriver(options);
//        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(1920, 1000));
        driver.get("http://selenium1py.pythonanywhere.com/de");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(enabled = false)
    public void tearDown(ITestResult result) {

        if(result.isSuccess()) {
            logger.info("Test result: PASSED");
        }else {
            logger.error("Test result: FAILED" + "\n" + new PageBase(driver)
                    //.takeScreenShotWithScrollDown());
                    .takeScreenshot());
        }
        logger.info("Stop test: "+ result.getTestName());
        logger.info("*****************************");

        driver.quit();
    }

}
