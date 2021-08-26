package oscar.tests;

import org.openqa.selenium.WebElement;
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

    @Test
    public void createOrderPositiveTest() {

        new HomePage(driver).selectCategory();
        new OrderHistoryPage(driver).addTheBookToBasket().goToBasketView()
                .proceedToBuyBook();
        new ShippingAddressPage(driver).fillPersonalDate("Sidor", "Sidorov")
                .fillAddress("Otto-Grot-Strasse-50", "Hamburg", "21031")
                .selectCountry("Germany").clickOnContinueButton();
        new PaymentPage(driver).clickOnSubmitButton();
        new OrderOverviewPage(driver).orderSubmit();

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
}

