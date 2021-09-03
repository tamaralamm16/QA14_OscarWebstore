package oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    @FindBy(xpath = "//a[contains(text(),'Oscar')]")
    WebElement homePageName;

    public boolean isHomePageNameVisible() {
        return homePageName.isDisplayed();
    }
    @FindBy(xpath = "//a[contains(text(),'All products')]")
    WebElement allProducts;

    public boolean isAllProductsVisible() {
        return allProducts.isDisplayed();
    }
    @FindBy(css = "li:nth-child(3) > a")
    WebElement clothing;

    public boolean isClothingVisible() {
        return clothing.isDisplayed();
    }
    @FindBy(css = "li:nth-child(4) > a")
    WebElement books;

    public boolean isBooksVisible() {
        return books.isDisplayed();
    }
    @FindBy(css = "li:nth-child(6) > a")
    WebElement offers;

    public boolean isOffersVisible() {
        return offers.isDisplayed();
    }
    public  ProductPage isHomePageNameClickable() {
        homePageName.click();
        return new ProductPage(driver);
    }
    public ProductPage isAllProductsClickable() {
        allProducts.click();
        return new ProductPage(driver);
    }
    public HomePage isClothingClickable() {
        clothing.click();
        return this;
    }
    public HomePage isBooksClickable() {
        books.click();
        return this;
    }
    public HomePage isOffersClickable() {
        offers.click();
        return this;
    }
    @FindBy(xpath = "//h2[contains(text(),'Welcome!')]")
    WebElement welcome;

    public HomePage isWelcomeMessageAppears() {
        welcome.isDisplayed();
        return this;
    }

    public boolean isContainsTextForHomePageName(String text) {
        return homePageName.getText().contains(text);
    }

    public HomePage goToHomePageName() {
        homePageName.click();
        return this;
    }
    @FindBy(xpath = "//a[@id='login_link']")
    WebElement login;

    public RegisterPage isLoginPageAppears() {
        login.click();
        return new RegisterPage(driver);
    }
    @FindBy(css = ".navbar-right > .btn")
    WebElement searchBtn;

    public boolean isSearchBtnClickable() {
        searchBtn.click();
        return isElementClickable(searchBtn, 10);
    }

    public boolean isLoginOrRegisterPageDisplayed() {
    return loginLink.isDisplayed();
    }
    @FindBy(css = ".dropdown-submenu")
    WebElement booksCategory;

    public HomePage selectAllProducts() {
        booksCategory.click();
        return this;
    }
}
