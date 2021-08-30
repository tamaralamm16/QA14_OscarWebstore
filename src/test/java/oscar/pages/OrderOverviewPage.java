package oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderOverviewPage extends PageBase {
    public OrderOverviewPage(WebDriver driver) {
        super(driver);
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

    @FindBy(xpath = "//a[contains(text(),'Coders at Work')]")
    WebElement orderHeader;

    public String getOrderNumber() {
        return orderHeader.getText();

    }
    @FindBy(xpath = "//button[@id='place-order']")
    WebElement continueBtn;

    public OrderOverviewPage clickOnContinueOrder() {
       clickWithAction(continueBtn, 0, 1000);
        return this;
    }
    @FindBy(xpath = "//body/div[1]/div[1]/div[2]")
    WebElement orderNumber;

    public String getOrderNumber2() {
        return orderNumber.getText();
    }

    @FindBy(id = "view_preview")
    WebElement submitBtn;

    public OrderOverviewPage providePaymentInformation() {
        submitBtn.click();
        return this;
    }
}

