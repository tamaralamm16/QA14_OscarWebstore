package oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends  PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".dropdown-submenu")
    WebElement submenuBook;

    public ProductPage selectCategory() {
        submenuBook.click();
        return new ProductPage(driver);
    }

    @FindBy(id = "login_link")
    WebElement loginLink;

    public RegisterPage clickOnLoginOrRegisterBtn() {
        loginLink.click();
        return new RegisterPage(driver);
    }
    @FindBy(id = "messages")
    WebElement willkomenMessage;

    @FindBy(css = ".icon-exclamation-sign")
    WebElement errorMessage;

    public boolean isWillkomenMessageAppears() {
       return  willkomenMessage.isDisplayed();
    }

    public boolean isErrorMessageAppears() {
        return errorMessage.isDisplayed();
    }
}
