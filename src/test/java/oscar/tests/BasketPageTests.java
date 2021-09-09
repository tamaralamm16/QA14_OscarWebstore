package oscar.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.*;

public class BasketPageTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).clickOnLoginOrRegisterBtn();
        new RegisterPage(driver).fillLoginForm("Sidorov@mail.ru", "Sidor12345$");
    }

    @Test
    public void verifyIfTotalAmountChangedAfterUpdate() {

        new HomePage(driver).selectCategory();
        new OrderHistoryPage(driver).addTheBookToBasket().goToBasketView()
                .proceedToBuyBook();
        new ShippingAddressPage(driver).fillAddressFormFromShippingPage("Sidor", "Sidorov",
                "Otto-Grot-Strasse-50", "Hamburg", "21031", "Germany");
        new OrderOverviewPage(driver).providePaymentInformation().clickEditOrder().fillQuantityField("0");

        Assert.assertTrue(new OrderOverviewPage(driver).isBasketOverviewDisplayed());

    }
    @Test
    public void verifyIfTotalSumIsCorrect() {
        new HomePage(driver).selectCategory();
        new ProductPage(driver).clickOnItemName(11).addToBasket();
        new OrderHistoryPage(driver).goToBasketView();

        double priceForOne;
        priceForOne = new ProductPage(driver).getPriseForOne();
        System.out.println(priceForOne);

        new ProductPage(driver).fillQuantityField("2");

        double totalPrise;
        totalPrise = new ProductPage(driver).getTotalPrise();
        System.out.println(totalPrise);

        Assert.assertEquals(totalPrise, priceForOne * 2);
    }

//    @Test
//    public void checkTotalPriseTest() {
//        new HomePage(driver).selectCategory();
//        new ProductPage(driver).addItemToBasket(1);
//        new ProductPage(driver).clickOnViewBasketBtn();
//        double price = new ProductPage(driver).getPrice();
//        System.out.println(price);
//        new ProductPage(driver).fillQuantityField("2");
//        Assert.assertEquals(new ProductPage(driver).getPrice(), price * 2);
//    }
//
//    @Test
//    public void checkOnCountProductIsDeletedFromBasketTest() {
//        new ProductPage(driver).addItemToBasket(1).addItemToBasket(2).clickOnViewBasketBtn();
//
//        int itemList = new ProductPage(driver).getItemCountList();
//        new ProductPage(driver).fillQuantityField("0");
//        Assert.assertEquals(new ProductPage(driver).getItemCountList(), itemList - 1);
//    }

    }


