package oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_registration-email")
    WebElement emailField;

    @FindBy(id = "id_registration-password1")
    WebElement passwordField;

    @FindBy(id = "id_registration-password2")
    WebElement confirmPswdField;

    @FindBy(name = "registration_submit")
    WebElement registerBtn;

    public RegisterPage fillRegisterForm(String email, String pwd, String pwd1) {
        type(emailField, email);
        type(passwordField, pwd);
        type(confirmPswdField, pwd1);
        registerBtn.click();
        return this;

    }
    @FindBy(id = "register_form")
    WebElement registerForm;

    public boolean isRegisterFormDisplayed() {
        return registerForm.isDisplayed();
    }
    @FindBy(css = ".error-block")
    WebElement errorMessage;

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
    @FindBy(xpath = "//div[contains(text(),'Thanks for registering!')]")
    WebElement welcome;

    public boolean isWelcomeMessageDisplayed() {
        return welcome.isDisplayed();
    }
    @FindBy(css = ".icon-user")
    WebElement account;


    public RegisterPage goToUserAccount() {
        account.click();
        return this;
    }
    @FindBy(id = "id_login-username")
    WebElement emailInputField;

    @FindBy(id = "id_login-password")
     WebElement pswdInputField;

    @FindBy(css = "#login_form > .btn")
    WebElement loginSubmit;

    public RegisterPage fillLoginForm(String email, String pswd) {
        type(emailInputField, email);
        type(pswdInputField, pswd);
        loginSubmit.click();
        return this;
    }
    public RegisterPage isAccountIconClickable() {
        account.click();
        return this;
    }


}
