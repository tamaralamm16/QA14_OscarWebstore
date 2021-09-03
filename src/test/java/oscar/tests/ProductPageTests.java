package oscar.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.*;

public class ProductPageTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).goToHomePageName();
    }

    @Test(priority = 1, groups = {"functional"})
    public void verifyIfPaginationWorks() {
        new HomePage(driver).selectCategory();
        new ProductPage(driver).clickOnPageNumber();

        Assert.assertTrue(new ProductPage(driver).getPageNumber2().contains("Seite 2 von 10"));

        String pageNumber2;
        pageNumber2 = new ProductPage(driver).getPageNumber2();
        System.out.println(pageNumber2);

        new ProductPage(driver).clickOnPageNumber();
        Assert.assertTrue(new ProductPage(driver).getPageNumber3().contains("Seite 3 von 10"));

        String pageNumber3;
        pageNumber3 = new ProductPage(driver).getPageNumber3();
        System.out.println(pageNumber3);
    }

    @Test(priority = 2, groups = {"functional"})
    public void verifyIfPaginationWorksBack() {
        new HomePage(driver).selectCategory();
        new ProductPage(driver).clickOnPageNumber().clickOnPageNumber();
        new ProductPage(driver).clickBackArrowInPagination();
        Assert.assertTrue(new ProductPage(driver).getPageNumber2().contains("Seite 2 von 10"));
    }

    @Test(priority = 3, groups = {"functional"})
    public void verifyIfUserCanReturnToHomePage() {
        new HomePage(driver).selectCategory();
        new ProductPage(driver).clickOnPageNumber().clickOnPageNumber()
        .goBackWithStartButton();
        Assert.assertTrue(new HomePage(driver).isLoginOrRegisterPageDisplayed());
    }
    @Test(priority = 4, groups = {"functional"})
    public void verifyCorrectBookName() {
        new HomePage(driver).selectCategory();

        String bookTitle;
        bookTitle = new ProductPage(driver).getBookTitle();
        System.out.println(bookTitle);

        new ProductPage(driver).selectBook();

        String bookTitleReloaded;
        bookTitleReloaded = new ProductPage(driver).getBookTitleReloaded();
        System.out.println(bookTitleReloaded);

        Assert.assertEquals(bookTitle, bookTitleReloaded);
    }

    @Test(priority = 5, groups = {"functional"})
    public void verifyIfUnregisteredUserCanByProduct() {
        new HomePage(driver).selectCategory();
        new ProductPage(driver).selectProduct().addToBasket().continueShopping();
        Assert.assertTrue(new ProductPage(driver).isNewCustomerFormAppears());
    }

    @Test(priority = 6, groups = {"functional"})
    public void verifyIfAddToBasketWorksForAllProduct() {
        new HomePage(driver).selectAllProducts();
        new ProductPage(driver).selectProductFromBooks();
        new OrderHistoryPage(driver).submit().goToBasketView();

        Assert.assertTrue(new ProductPage(driver).verifyBookNameFromBasket().contains("Google Hacking"));

    }
}
