package oscar.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.*;

public class OrderHistoryTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).clickOnLoginOrRegisterBtn();
        new RegisterPage(driver).fillLoginForm("Sidorov@mail.ru", "Sidor12345$");
    }

    @Test(priority = 1, groups = {"functional"})
    public void createOrderPositiveTest() {

        new HomePage(driver).selectCategory();
        new OrderHistoryPage(driver).addTheBookToBasket().goToBasketView()
                .proceedToBuyBook();
        new ShippingAddressPage(driver).fillAddressFormFromShippingPage("Sidor", "Sidorov",
                "Otto-Grot-Strasse-50", "Hamburg", "21031", "Germany");
        new OrderOverviewPage(driver).providePaymentInformation();

        String orderNumber;
        orderNumber = new OrderOverviewPage(driver).getOrderNumber();
        System.out.println(orderNumber);

        new OrderOverviewPage(driver).clickOnContinueOrder();
        new ProfilePage(driver).userAccountPreview().checkOrderOverview();
        Assert.assertEquals(new OrderOverviewPage(driver).getOrderNumber2(),orderNumber);

        String orderNumber2;
        orderNumber2 = new OrderOverviewPage(driver).getOrderNumber2();
        System.out.println(orderNumber2);

    }
    @Test(priority = 2, groups = {"functional"})
    public void createOrderNegativeTest() {

        new HomePage(driver).selectCategory();
        new OrderHistoryPage(driver).addTheBookToBasket().goToBasketView()
                .proceedToBuyBook();
        new ShippingAddressPage(driver).fillAddressFormFromShippingPage("%", "%", "Otto-Grot-Strasse-50",
                "Hamburg", "21031", "Germany");

        new OrderOverviewPage(driver).providePaymentInformation();

        Assert.assertTrue(new ProfilePage(driver).isAddressContainsSpecialSymbol("%"));
    }
}

