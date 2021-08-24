package oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderOverviewPage extends PageBase {
    public OrderOverviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Coders at Work')]")
    WebElement bookName;


    public OrderOverviewPage ensureIfTheRightBookIsInTheBasket(String name) {
        bookName.getText();
        return this;
    }

    @FindBy(id = "place-order")
    WebElement submitOrder;

    public OrderOverviewPage orderSubmit() {
        clickWithAction(submitOrder, 0, 800);
        return this;
    }

    @FindBy(xpath = "(//a[contains(@href, '/de/')])[4]")
    WebElement continueShoppingBtn;

    public HomePage continueShopping() {
        clickWithAction(continueShoppingBtn, 0, 800);
        return new HomePage(driver);
    }

    @FindBy(css = "strong")
    WebElement orderHeader;

    public String getOrderNumber() {
        return orderHeader.getText();

    }
    @FindBy(xpath = "//a[.='Einkauf fortsetzen']")
    WebElement continueBtn;

    public OrderOverviewPage clickOnContinueOrder() {
        continueBtn.click();
        return this;
    }
    @FindBy(css = "tr:nth-child(2)  a")
    WebElement orderNumber;

    public String getOrderNumber2() {
        return orderNumber.getText();
    }


}

