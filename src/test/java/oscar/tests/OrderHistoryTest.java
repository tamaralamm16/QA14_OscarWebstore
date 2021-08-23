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
    }

    @Test
    public void existedUserSelectProductTest() {
        new RegisterPage(driver).fillLoginForm("Kuznetsov3@mail.ru", "Kuz35512$%");
        Assert.assertTrue(new HomePage(driver).isWillkomenMessageAppears());
        new HomePage(driver).selectCategory();
        new OrderHistoryPage(driver).goToBookDescription().checkBookDescription();
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
}

