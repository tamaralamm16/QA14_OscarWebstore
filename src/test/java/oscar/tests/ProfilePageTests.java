package oscar.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.HomePage;
import oscar.pages.OrderHistoryPage;
import oscar.pages.ProfilePage;
import oscar.pages.RegisterPage;

public class ProfilePageTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).clickOnLoginOrRegisterBtn();
    }

    @Test(priority = 1, groups = {"functional"})
    public void newUserRegistrationPositiveTest() {
        new RegisterPage(driver).fillRegisterForm("Anna1@gmail.com", "Ann112345$", "Ann112345$");
        new RegisterPage(driver).isWelcomeMessageDisplayed();

    }

    @Test(priority = 2, groups = {"functional"})
    public void existedUserChangePasswordTest() {
        new RegisterPage(driver).fillLoginForm("Anna1@gmail.com", "Ann112345$");
        new ProfilePage(driver).userAccountPreview().changePassword().typeOldPassword("Ann112345$")
                .typeNewPassword1("Anna112345$").typeNewPassword2("Anna112345$").saveChangedPassword();
        Assert.assertTrue(new ProfilePage(driver).isPasswordChangedMessageAppears());
    }

    @Test(priority = 3, groups = {"functional"})
    public void editProfileTest() {
        new RegisterPage(driver).fillLoginForm("Anna1@gmail.com", "Anna112345$");
        new ProfilePage(driver).userAccountPreview().pressEditProfileBtn()
                .editProfile("Anna", "Sidorova", "Anna1@mail.ru");

        Assert.assertTrue(new ProfilePage(driver).isEmailContainsText("Anna1@mail.ru"));
    }

    @Test(priority = 4, groups = {"functional"})
    public void addressBookTest() {
        new RegisterPage(driver).fillLoginForm("Anna1@mail.ru", "Anna112345$");
        new ProfilePage(driver).userAccountPreview().goToAddressBook().addNewAddress()
                .fillAddressFormFromProfilePage("Anna", "Sidorova", "Tungerstraße-20",
                        "Erfurt", "99099", "Germany")
                .isAddressContainsText("Erfurt");
    }

    @Test(priority = 5, groups = {"functional"})
    public void addressBookTestNegativeTestWithWrongCountry() {
        new RegisterPage(driver).fillLoginForm("Anna1@mail.ru", "Anna112345$");
        new ProfilePage(driver).userAccountPreview().goToAddressBook().addNewAddress()
                .fillAddressFormFromProfilePage("Anna", "Sidorova", "Tungerstraße-20", "Erfurt", "99099","Canada")
                .isErrorMessageAppears();
    }

    @Test(priority = 6, groups = {"functional"})
    public void createWishListsTest() {
        new RegisterPage(driver).fillLoginForm("Anna1@mail.ru", "Anna112345$");
        new ProfilePage(driver).userAccountPreview().selectWishList().createNewWishList()
                .nameNewWishList("Agile").submitWishListName().isWishListNameAppears("Agile");
    }
    @Test(priority = 7, groups = {"functional"})
    public void addBookToWishList() {
        new RegisterPage(driver).fillLoginForm("Anna1@mail.ru", "Anna112345$");
        new HomePage(driver).selectCategory();
        new OrderHistoryPage(driver).goToBookDescription().addBookToWishList();
        new ProfilePage(driver).userAccountPreview().selectWishList().isWishListNameAppears("Agile");
    }

    @Test(priority = 8, groups = {"functional"})
    public void deleteProfileTest() {
        new RegisterPage(driver).fillLoginForm("Anna1@mail.ru", "Anna112345$");
        new ProfilePage(driver).userAccountPreview().pressDeleteProfileBtn()
                .passwordInput("Anna112345$").deleteConfirmation();
    }

}
