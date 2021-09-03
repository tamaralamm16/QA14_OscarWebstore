package oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class ProductPage extends PageBase {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".page-header.action")
    WebElement pageHeader;

    public boolean isItProductPage() {
        return pageHeader.isDisplayed();
    }

    @FindBy(xpath = "//h1[contains(text(),'All products')]")
    WebElement allProducts;

    public boolean isContainsTextForAllProducts(String text) {
        return allProducts.getText().contains(text);
    }

    @FindBy(xpath = "//h1[contains(text(),'Clothing')]")
    WebElement clothing;

    public boolean isContainsTextForClothing(String text) {
        return clothing.getText().contains(text);
    }

    @FindBy(xpath = "//h1[contains(text(),'Books')]")
    WebElement books;

    public boolean isContainsTextForBooks(String text) {
        return books.getText().contains(text);
    }

    @FindBy(xpath = "//h1[contains(text(),'Offers')]")
    WebElement offers;

    public boolean isContainsTextForOffers(String text) {
        return offers.getText().contains(text);
    }

    @FindBy(xpath = "//a[contains(text(),'Weiter')]")
    WebElement pageNumber1;

    public ProductPage clickOnPageNumber() {
        pageNumber1.click();
        return this;
    }

    @FindBy(xpath = "//li[contains(text(),'Seite 2 von 10')]")
    WebElement pageNumber2;

    public String getPageNumber2() {
        return pageNumber2.getText();
    }

    @FindBy(xpath = "//li[contains(text(),'Seite 3 von 10')]")
    WebElement pageNumber3;

    public String getPageNumber3() {
        return pageNumber3.getText();
    }

    @FindBy(xpath = "//a[contains(text(),'Zurück')]")
    WebElement arrowBack;

    public ProductPage clickBackArrowInPagination() {
        arrowBack.click();
        return this;
    }
    @FindBy(xpath = "//a[contains(text(),'Start')]")
    WebElement startBtn;

    public ProductPage goBackWithStartButton() {
        startBtn.click();
        return null;
    }
    @FindBy(xpath = "//a[contains(text(),'Applied cryptography')]")
    WebElement bookName;

    public String getBookTitle() {
        return bookName.getText();
    }

    public ProductPage selectBook() {
        bookName.click();
        return this;
    }
    @FindBy(xpath = "//h1[contains(text(),'Applied cryptography')]")
    WebElement bookNameReloaded;

    public String getBookTitleReloaded() {
        return bookNameReloaded.getText();
    }
    @FindBy(xpath = "//a[contains(text(),'Google Hacking')]")
    WebElement productName;

    public ProductPage selectProduct() {
        productName.click();
        return this;
    }
    @FindBy(id = "add_to_basket_form")
    WebElement addToBasketBtn;

    public ProductPage addToBasket() {
        addToBasketBtn.click();
        return this;
    }
    @FindBy(xpath = "//a[contains(text(),'Weiter zur Kasse')]")
    WebElement continueBtn;

    public ProductPage continueShopping() {
        continueBtn.click();
        return this;
    }
    @FindBy(xpath = "//h1[contains(text(),'Wer sind Sie?')]")
    WebElement newCustomerForm;

    public boolean isNewCustomerFormAppears() {
        return newCustomerForm.isDisplayed();
    }
    @FindBy(xpath = "//a[contains(text(),'Silence On The Wire')]")
    WebElement productBookName;

    public ProductPage selectProductFromBooks() {
        productName.click();
        return this;
    }
    @FindBy(xpath = "//a[contains(text(),'Google Hacking')]")
    WebElement bookNameFromBasket;
    public String verifyBookNameFromBasket() {
        return bookNameFromBasket.getText();
    }
}
