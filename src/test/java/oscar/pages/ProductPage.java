package oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageBase {
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (css = ".page-header.action")
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
}
