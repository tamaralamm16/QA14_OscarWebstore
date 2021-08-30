package oscar.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.HomePage;
import oscar.pages.ProfilePage;
import oscar.pages.RegisterPage;
import oscar.utils.DataProviders;

public class RegisterPageTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).clickOnLoginOrRegisterBtn();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "registerNegativeUsingFile")
    public void newUserRegistrationNegative(String email) {
        new RegisterPage(driver).fillRegisterForm(email, "Vk12345%", "Vk12345%");
        Assert.assertTrue(new RegisterPage(driver).isRegisterFormDisplayed());
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "registerNegativeUsingFilePassword")
    public void newUserRegistrationNegativeWrongPassword(String password) {
        new RegisterPage(driver).fillRegisterForm("IvanIvanov@gmail.com", password, password);
        Assert.assertTrue(new RegisterPage(driver).isRegisterFormDisplayed());
    }
    @Test(priority = 3, groups = {"functional"})
    public void newUserRegistrationWithTheExistingUser() {
        new RegisterPage(driver).fillRegisterForm("Sidorov@mail.ru", "Sidor12345$", "Sidor12345$");
        new RegisterPage(driver).isErrorMessageDisplayed();
    }
    @Test(priority = 2, groups = {"functional"})
    public void newUserRegistrationPositiveTest() {
        new RegisterPage(driver).fillRegisterForm("Sidorov@mail.ru", "Sidor12345$", "Sidor12345$");
        new RegisterPage(driver).isWelcomeMessageDisplayed();

    }
    @Test(priority = 1, groups = {"functional"})
    public void deleteNeuRegisteredUserTest() {
        new RegisterPage(driver).fillRegisterForm("Sidorov@mail.ru", "Sidor12345$", "Sidor12345$")
       .goToUserAccount();
        Assert.assertTrue(new ProfilePage(driver).isProfilePageDisplayed());
        new ProfilePage(driver).deleteProfile().confirmDeleteUser("Sidor12345$");
    }

 @Test(dataProviderClass = DataProviders.class, dataProvider = "registerUsersToBeDeleted")
    public void deleteNeuRegisteredUsersTest(String email, String pwd, String pwd1) {
        new RegisterPage(driver).fillRegisterForm(email, pwd, pwd1)
       .goToUserAccount();
        Assert.assertTrue(new ProfilePage(driver).isProfilePageDisplayed());
        new ProfilePage(driver).deleteProfile().confirmDeleteUser(pwd1);
    }

}