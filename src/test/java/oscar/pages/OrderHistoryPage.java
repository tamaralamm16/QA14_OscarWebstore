package oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends PageBase {
    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[contains(text(),'Order History')]")
    WebElement orderHistoryBtn;

    @FindBy(xpath = "//p[contains(text(),\"You haven't placed any orders.\")]")
    WebElement ordersSummary;

    public  OrderHistoryPage goToOrderHistory() {
        orderHistoryBtn.click();
        return new OrderHistoryPage(driver);
    }
    public boolean isOrdersSummaryMessageDisplayed() {
        return ordersSummary.isDisplayed();
    }
    @FindBy(css = ".col-xs-6:nth-child(3) h3 > a")
    WebElement bookToBeAddedToBasket;

    public OrderHistoryPage goToBookDescription() {
        bookToBeAddedToBasket.click();
        return new OrderHistoryPage(driver);
    }
    @FindBy(xpath = "//h1[contains(text(),'Coders at Work')]")
    WebElement bookName;

    public boolean  checkBookDescription() {
        return bookName.isDisplayed();
    }
    @FindBy(xpath = "(//button[@type='submit'])[4]")
    WebElement addToBasketBtn;

    public OrderHistoryPage addTheBookToBasket() {
        addToBasketBtn.click();
        return new OrderHistoryPage(driver);
    }
    @FindBy(css = ".btn-group > .btn:nth-child(1)")
    WebElement viewBasketBtn;

    public OrderHistoryPage goToBasketView() {
        viewBasketBtn.click();
        return new OrderHistoryPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Weiter zur Kasse')]")
    WebElement proceedToCheckOut;

    public OrderHistoryPage proceedToBuyBook() {
        clickWithAction(proceedToCheckOut, 0, 700);
        return this;
    }



}
