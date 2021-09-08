package oscar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;
import java.util.List;

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
    @FindBy(css = ".col-xs-6:nth-child(1) h3 > a")
    WebElement itemTitle;

    public String getItemNameFromList(int number) {
        return driver.findElement(By.cssSelector(".col-xs-6:nth-child("+ number +") h3 > a"))
                .getText();
    }

    @FindBy(css = "h1")
    WebElement productTitle;

    public ProductPage clickOnItemName(int num) {
        driver.findElement(By.cssSelector(".col-xs-6:nth-child("+ num +") h3 > a")).click();
        return this;
    }

    public String getItemName() {
        return productTitle.getText();
    }
    @FindBy(css = ".nav-list > li > ul > li:nth-child(1) > a")
    WebElement fiction;

    public ProductPage selectBookFromFiction() {
        fiction.click();
        return this;
    }
    @FindBy(css = ".basket-items:nth-child(6) :nth-child(4)")
    WebElement priseForOne;

    public double getPriseForOne() {
        double number1 = Double.parseDouble(priseForOne.getText().replace("£", "")
                .replace(",", "."));
        return number1;
        }

    @FindBy(css = ".basket-items:nth-child(6) :nth-child(5)")
    WebElement totalPrise;

    public double getTotalPrise() {
        double number2 = Double.parseDouble(totalPrise.getText().replace("£", "")
        .replace(",", "."));
        return number2;
    }
    @FindBy(xpath = "//input[@id='id_form-0-quantity']")
    WebElement amount;

    public int getAmount() {
        int number3 = Integer.parseInt(amount.getText());
        return number3;
    }
    @FindBy(css = ".col-xs-6:nth-child(1) .btn")
    WebElement addToBasket;

    public ProductPage addItemToBasket(int number) {
        driver.findElement(By.cssSelector(".col-xs-6:nth-child(" + number + ") .btn")).click();
        return this;
    }

    public ProductPage clickOnViewBasketBtn() {
        basketViewBtn.click();
        return this;
    }

    @FindBy(xpath = "//a[.='View basket']")
    WebElement basketViewBtn;

    @FindBy(id = "id_form-0-quantity")
    WebElement quantity;

    @FindBy(css = ".input-group-btn .btn")
    WebElement updateQuantity;

    @FindBy(css = ".col-sm-2 .price_color")
    WebElement price;

    public double getPrice() {
        double num = Double.parseDouble(price.getText().replace("£", "")
                .replace(",", "."));
        return num;
    }

    public ProductPage fillQuantityField(String n) {
        type(quantity, n);
        updateQuantity.click();
        return this;
    }

    @FindBy(css = ".basket-items")
    List<WebElement> itemList;

    public int getItemCountList() {
        int countOfItem = itemList.size();
        System.out.println(countOfItem);
//        for(int i = 0; i < countOfItem; i++) {
//            WebElement itemResultList = itemList.get(i);
//        }
        return countOfItem;
    }
}

