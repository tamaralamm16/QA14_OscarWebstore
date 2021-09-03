package oscar.pages;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PageBase {
    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectDropDownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void clickWithAction(WebElement element, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + ", " + y + ")");
        element.click();
    }


    public String takeScreenshot() {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshot/screen" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot.getAbsolutePath();
    }

    public Screenshot takeScreenShotWithScrollDown() {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(1.25f), 1000))
                .takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File("screenshot/screen" + System.currentTimeMillis() + ".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot;
    }

    public void fillAddressForm(WebElement fname, String firstName, WebElement lname, String lastName, WebElement fline, String street,
                                WebElement city, String cityName, WebElement zip, String postCode, WebElement countryId, String country) {
        type(fname, firstName);
        type(lname, lastName);
        type(fline, street);
        type(city, cityName);
        type(zip, postCode);
        Select select = new Select(countryId);
        select.selectByVisibleText(country);

        List<WebElement> options = select.getOptions();
        System.out.println(select.getFirstSelectedOption().getText());
    }

    public boolean isElementClickable(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
