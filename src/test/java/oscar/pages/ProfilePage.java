package oscar.pages;

import ch.qos.logback.core.net.QueueFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProfilePage extends PageBase {


    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='messages']")
    WebElement profile;

    @FindBy(id = "delete_profile")
    WebElement deleteBtn;

    @FindBy(xpath = "//button[contains(text(), 'Löschen')]")
    WebElement submitDelete;

    @FindBy(xpath = "//input[@id='id_password']")
    WebElement pswdField;

    @FindBy(xpath = "//a[contains(text(),'Order History')]")
    WebElement orderHistoryBtn;


    public boolean isProfilePageDisplayed() {
        return profile.isDisplayed();
    }

    public ProfilePage deleteProfile() {
        deleteBtn.click();
        return this;
    }

    public ProfilePage confirmDeleteUser(String pwd) {
        type(pswdField, pwd);
        submitDelete.click();
        return this;
    }

    public ProfilePage goToOrderHistory() {
        orderHistoryBtn.click();
        return this;
    }

    @FindBy(css = ".icon-user")
    WebElement iconUser;

    public ProfilePage userAccountPreview() {
        iconUser.click();
        return new ProfilePage(driver);
    }

    @FindBy(xpath = "//aside/ul/li[2]/a")
    WebElement orderOverview;

    public ProfilePage checkOrderOverview() {
        orderOverview.click();
        return this;
    }

    @FindBy(xpath = "//td[contains(text(),'Sidorov@abc.de')]")
    WebElement userEmail;

    public String getUserEmail() {
        return userEmail.getText();
    }

    @FindBy(xpath = "//a[contains(text(),'Passwort ändern')]")
    WebElement passwordChangeBtn;

    public ProfilePage changePassword() {
        passwordChangeBtn.click();
        return this;
    }

    @FindBy(id = "id_old_password")
    WebElement oldPassword;

    public ProfilePage typeOldPassword(String pwd) {
        type(oldPassword, pwd);
        return this;
    }

    @FindBy(id = "id_new_password1")
    WebElement newPassword1;

    public ProfilePage typeNewPassword1(String pwd1) {
        type(newPassword1, pwd1);
        return this;
    }

    @FindBy(id = "id_new_password2")
    WebElement newPassword2;

    public ProfilePage typeNewPassword2(String pwd1) {
        type(newPassword2, pwd1);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Sichern')]")
    WebElement savePassword;

    public ProfilePage saveChangedPassword() {
        savePassword.click();
        return this;
    }

    @FindBy(id = "messages")
    WebElement passwordChangedMessage;

    public boolean isPasswordChangedMessageAppears() {
        return passwordChangedMessage.isDisplayed();

    }

    @FindBy(xpath = "//a[contains(text(),'Profil bearbeiten')]")
    WebElement editProfileBtn;

    public ProfilePage pressEditProfileBtn() {
        editProfileBtn.click();
        return this;
    }

    @FindBy(id = "id_first_name")
    WebElement firstName;

    @FindBy(id = "id_last_name")
    WebElement secondName;

    @FindBy(id = "id_email")
    WebElement emailField;

    @FindBy(xpath = "//button[contains(text(),'Sichern')]")
    WebElement submitBtn;

    @FindBy(xpath = "//div[@id='messages'][contains(.,'Benutzerprofil aktualisiert')]")
    WebElement iconOkSign;

    public ProfilePage editProfile(String fName, String sName, String email) {
        type(firstName, fName);
        type(secondName, sName);
        type(emailField, email);
        submitBtn.click();
        return this;
    }

    @FindBy(xpath = "//td[contains(.,'Anna1@mail.ru')]")
    WebElement eMail;


    public boolean isEmailContainsText(String text) {
        return eMail.getText().contains("Anna1@mail.ru");
    }

    @FindBy(id = "delete_profile")
    WebElement deleteProfileBtn;

    public ProfilePage pressDeleteProfileBtn() {
        deleteProfileBtn.click();
        return this;
    }

    @FindBy(id = "id_password")
    WebElement idPassword;

    public ProfilePage passwordInput(String pswd) {
        type(idPassword, pswd);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Löschen')]")
    WebElement deleteButton;

    public ProfilePage deleteConfirmation() {
        deleteButton.click();
        return this;
    }

    @FindBy(xpath = "//a[contains(text(),'Adressbuch')]")
    WebElement addressBookBtn;

    public ProfilePage goToAddressBook() {
        addressBookBtn.click();
        return this;
    }

    @FindBy(xpath = "//a[contains(text(),'Neue Adresse hinzufügen')]")
    WebElement addAddressBtn;

    public ProfilePage addNewAddress() {
        addAddressBtn.click();
        return this;
    }
    @FindBy(id = "id_first_name")
    WebElement fNameFromAddress;

    @FindBy(id = "id_last_name")
    WebElement sNameFromAddress;

    @FindBy(id = "id_line1")
    WebElement line1;

    @FindBy(id = "id_line4")
    WebElement city;

    @FindBy(id = "id_postcode")
    WebElement postcode;

    public ProfilePage fillAddressForm(String fName, String sName, String firstLine, String cityName, String plz) {
        type(fNameFromAddress, fName);
        type(sNameFromAddress, sName);
        type(line1, firstLine);
        type(city, cityName);
        type(postcode, plz);
        return this;
    }
    @FindBy(id = "id_country")
    WebElement choosedCountry;

    public ProfilePage selectCountryFromAddressForm(String country) {
        Select select = new Select(choosedCountry);
        select.selectByVisibleText(country);

        List<WebElement> options = select.getOptions();
        System.out.println(select.getFirstSelectedOption().getText());
        return this;
    }
    @FindBy (xpath = "//button[contains(text(),'Sichern')]")
    WebElement confirmAddress;

    public ProfilePage submitAddress() {
        confirmAddress.click();
        return this;
    }
    @FindBy(xpath = "//tbody/tr[2]/td[1]/address[1]")
    WebElement address;

    public boolean isAddressContainsText(String text) {
        return address.getText().contains(text);
    }
    @FindBy(xpath = "//strong[contains(text(),'Ups! Es sind Fehler aufgetreten')]")
    WebElement errorMessage;

    public boolean isErrorMessageAppears() {
        return errorMessage.isDisplayed();
    }
    @FindBy(xpath = "//a[contains(text(),'Wunschzettel')]")
    WebElement wishListBtn;

    public ProfilePage selectWishList() {
        wishListBtn.click();
        return this;
    }
    @FindBy(xpath = "//a[contains(text(),'Neuen Wunschzettel anlegen')]")
    WebElement newWishListBtn;

    public ProfilePage createNewWishList() {
        newWishListBtn.click();
        return this;
    }
    @FindBy(id = "id_name")
    WebElement wishListNameField;

    public ProfilePage nameNewWishList(String text) {
        type(wishListNameField, text);
        return this;
    }
    @FindBy(xpath = "//button[contains(text(),'Sichern')]")
    WebElement submitWishListName;

    public ProfilePage submitWishListName() {
        submitWishListName.click();
        return this;
    }
    @FindBy(xpath = "//div//h1")
    WebElement nameOfWishList;

    public boolean isWishListNameAppears(String text) {
        return nameOfWishList.isDisplayed();
    }
}

