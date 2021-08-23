package oscar.pages;

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
}

