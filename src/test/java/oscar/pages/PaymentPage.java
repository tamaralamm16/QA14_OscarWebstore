package oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends PageBase {
    public PaymentPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id= "view_preview")
    WebElement paymentBtn;

    public PaymentPage clickOnSubmitButton() {
        paymentBtn.click();
        return null;
    }
}
