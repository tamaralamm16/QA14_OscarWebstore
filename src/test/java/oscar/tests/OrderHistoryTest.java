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
        new RegisterPage(driver).fillLoginForm("Kuznetsov3@mail.ru", "Kuz35512$%");
    }

    @Test
    public void existedUserSelectProductTest() {
        new RegisterPage(driver).fillLoginForm("Kuznetsov3@mail.ru", "Kuz35512$%");
        Assert.assertTrue(new HomePage(driver).isWillkomenMessageAppears());
        new HomePage(driver).selectCategory();
        new OrderHistoryPage(driver).goToBookDescription();
        new OrderHistoryPage(driver).addTheBookToBasket().goToBasketView();
        new OrderHistoryPage(driver).proceedToBuyBook();
        Assert.assertTrue(new ShippingAddressPage(driver).isShippingAddressPageAppears());
        new ShippingAddressPage(driver).fillPersonalDate("Ivan", "Kuznetsov")
            .fillAddress("Otto-Grot-Strasse-50", "Hamburg", "21031")
            .selectCountry("Germany").clickOnContinueButton();
        new PaymentPage(driver).clickOnSubmitButton();
        new OrderOverviewPage(driver).ensureIfTheRightBookIsInTheBasket("Coders at Work").orderSubmit().continueShopping();
        new ProfilePage(driver).userAccountPreview().checkOrderOverview();
    }

    @Test
    public void createOrderPositiveTest() {

        new HomePage(driver).selectCategory();
        new OrderHistoryPage(driver).addTheBookToBasket().goToBasketView()
                .proceedToBuyBook();
        new ShippingAddressPage(driver).fillPersonalDate("Ivan", "Kuznetsov")
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

