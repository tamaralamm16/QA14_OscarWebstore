package oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingAddressPage extends PageBase {
    public ShippingAddressPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h1[contains(text(),'Lieferanschrift')]")
    WebElement shippingAddressHeader;

    public boolean isShippingAddressPageAppears() {
        return shippingAddressHeader.isDisplayed();
    }
    @FindBy(id = "id_first_name")
    WebElement fname;

    @FindBy(id = "id_last_name")
    WebElement lname;

    @FindBy(id = "id_line1")
    WebElement fline;

    @FindBy(id = "id_line4")
    WebElement city;

    @FindBy(id = "id_postcode")
    WebElement zip;

    @FindBy(id = "id_country")
    WebElement countryId;

    @FindBy(xpath = "//button[contains(text(),'Weiter')]")
    WebElement submit;

    public ShippingAddressPage fillAddressFormFromShippingPage(String firstName, String lastName,
                                                               String street, String cityName, String postCode,
                                                               String country) {
        fillAddressForm(fname, firstName, lname, lastName, fline, street, city, cityName, zip, postCode, countryId, country);
        submit.click();
        return this;

    }
}
