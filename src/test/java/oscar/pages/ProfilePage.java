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

    @FindBy(css = ".navbar-right > li:nth-child(1) > a")
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

    @FindBy(xpath = "//td[contains(text(),'Sidorov@mail.ru')]")
    WebElement userEmail;

    public boolean isUserEmailEqualText(String text) {
        return userEmail.getText().contains(text);
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

    @FindBy (xpath = "//button[contains(text(),'Sichern')]")
    WebElement confirmAddress;

    public ProfilePage fillAddressFormFromProfilePage(String firstName, String lastName, String street, String cityName, String postCode, String country) {
        fillAddressForm(fname, firstName, lname, lastName, fline, street, city, cityName, zip, postCode, countryId, country );
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
    @FindBy (xpath = "//address")
    WebElement addressField;

    public boolean isAddressContainsSpecialSymbol(String s) {
        return addressField.isDisplayed();
    }

    public boolean isContainsTextForIcon() {
       return iconUser.isDisplayed();
    }
    @FindBy(xpath = "//a[@id='logout_link']")
    WebElement logout;

    public ProfilePage isUserCanLogout() {
        logout.click();
        return this;
    }
    @FindBy(xpath = "//a[@id='login_link']")
    WebElement login;

    public boolean isLoginLinkAppears() {
        return login.isDisplayed();
    }

}

