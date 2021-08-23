package oscar.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.HomePage;
import oscar.pages.ProductPage;

public class HomePageTests extends TestBase {

    @Test
    public void userCanSelectProductMenuTest() {
        new HomePage(driver).selectCategory();
        Assert.assertTrue(new ProductPage(driver).isItProductPage());
    }
}
