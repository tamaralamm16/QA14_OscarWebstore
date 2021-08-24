package oscar.pages;

import ch.qos.logback.core.net.QueueFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@id='messages']")
    WebElement profile;

    @FindBy(id="delete_profile")
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

    public  ProfilePage deleteProfile() {
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

    public  ProfilePage userAccountPreview() {
        iconUser.click();
        return new ProfilePage(driver);
    }
    @FindBy(xpath = "//aside/ul/li[2]/a")
    WebElement orderOverview;

    public ProfilePage checkOrderOverview() {
        orderOverview.click();
        return this;
    }

    @FindBy(xpath = "//td[contains(text(),'Kuznetsov3@mail.ru')]")
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
        type(oldPassword, pwd );
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
    public boolean isConfirmationMessageAppears() {
        return iconOkSign.isDisplayed();
    }
    @FindBy(xpath = "//td[contains(.,'Kuznetsov@gmail.com')]")
    WebElement eMail;

    public String getEmail() {
        return eMail.getText();
    }
}

