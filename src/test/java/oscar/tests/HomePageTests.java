package oscar.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.HomePage;
import oscar.pages.ProductPage;
import oscar.pages.ProfilePage;
import oscar.pages.RegisterPage;

public class HomePageTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).goToHomePageName();
    }

    //    @Test
//    public void userCanSelectProductMenuTest() {
//        new HomePage(driver).selectCategory();
//        Assert.assertTrue(new ProductPage(driver).isItProductPage());
//    }
    @Test(priority = 1, groups = {"functional"})
    public void homePageHeaderVisibilityTest() {
        new HomePage(driver).isHomePageNameVisible();
        Assert.assertTrue(new HomePage(driver).isContainsTextForHomePageName("Oscar"));
    }

    @Test(priority = 2, groups = {"functional"})
    public void allProductsCategoryVisibilityTest() {
        new HomePage(driver).isAllProductsVisible();
        new HomePage(driver).isAllProductsClickable();
        Assert.assertTrue(new ProductPage(driver).isContainsTextForAllProducts("All products"));
    }

    @Test(priority = 3, groups = {"functional"})
    public void clothingCategoryVisibilityTest() {
        new HomePage(driver).isClothingVisible();
        new HomePage(driver).isClothingClickable();
        Assert.assertTrue(new ProductPage(driver).isContainsTextForClothing("Clothing"));
    }

    @Test(priority = 4, groups = {"functional"})
    public void booksCategoryVisibilityTest() {
        new HomePage(driver).isBooksVisible();
        new HomePage(driver).isBooksClickable();
        Assert.assertTrue(new ProductPage(driver).isContainsTextForBooks("Books"));
    }

    @Test(priority = 5, groups = {"functional"})
    public void offersCategoryVisibilityTest() {
        new HomePage(driver).isOffersVisible();
        new HomePage(driver).isOffersClickable();
        Assert.assertTrue(new ProductPage(driver).isContainsTextForOffers("Offers"));
    }

    @Test(priority = 6, groups = {"functional"})
    public void accountVisibilityTestForRegisteredUser() {
        new HomePage(driver).clickOnLoginOrRegisterBtn();
        new RegisterPage(driver).fillLoginForm("Sidorov@mail.ru", "Sidor12345$");
        new ProfilePage(driver).isContainsTextForIcon();
    }

    @Test(priority = 7, groups = {"functional"})
    public void logoutTestForRegisteredUser() {
        new HomePage(driver).clickOnLoginOrRegisterBtn();
        new RegisterPage(driver).fillLoginForm("Sidorov@mail.ru", "Sidor12345$");
        new ProfilePage(driver).isUserCanLogout().isLoginLinkAppears();
    }

    @Test(priority = 8, groups = {"functional"})
    public void accountVisibilityTestForUnregisteredUser() {
        new HomePage(driver).isLoginPageAppears();
    }
    @Test(priority = 9, groups = {"functional"})
    public void isSearchBtnFunctional() {
        new HomePage(driver).isSearchBtnClickable();
    }

}
