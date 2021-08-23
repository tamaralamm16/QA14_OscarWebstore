package oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

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

    public ShippingAddressPage fillPersonalDate(String firstName, String lastName) {
        type(fname, firstName);
        type(lname, lastName);
        return this;
    }

    public ShippingAddressPage fillAddress(String street, String cityName, String postCode) {
        type(fline, street);
        type(city, cityName);
        type(zip, postCode);
        return this;
    }

    public ShippingAddressPage selectCountry(String country) {
        Select select = new Select(countryId);
        select.selectByVisibleText(country);

        List<WebElement> options = select.getOptions();
        System.out.println(select.getFirstSelectedOption().getText());

       //for (int i = 0; i < options.size(); i++) {
        //   System.out.println(options.get(i).getText());
     //  }
        return this;
    }

    public PaymentPage clickOnContinueButton() {
        submit.click();
        return new PaymentPage(driver);
    }
}
