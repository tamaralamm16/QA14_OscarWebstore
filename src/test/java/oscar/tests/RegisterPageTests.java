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
    @Test
    public void newUserRegistrationWithTheExistingUser() {
        new RegisterPage(driver).fillRegisterForm("PPetrov@gmail.com", "PpOscar14$%", "PpOscar14$%");
        new RegisterPage(driver).isErrorMessageDisplayed();
    }
    @Test
    public void newUserRegistrationPositiveTest() {
        new RegisterPage(driver).fillRegisterForm("Kuznetsov6@mail.ru", "Kuz65512$%", "Kuz65512$%");
        new RegisterPage(driver).isWelcomeMessageDisplayed();

    }
    @Test
    public void deleteNeuRegisteredUserTest() {
        new RegisterPage(driver).fillRegisterForm("Kuznetsov7@mail.ru", "Kuz75512$%", "Kuz75512$%")
       .goToUserAccount();
        Assert.assertTrue(new ProfilePage(driver).isProfilePageDisplayed());
        new ProfilePage(driver).deleteProfile().confirmDeleteUser("Kuz75512$%");
    }

 @Test(dataProviderClass = DataProviders.class, dataProvider = "registerUsersToBeDeleted")
    public void deleteNeuRegisteredUsersTest(String email, String pwd, String pwd1) {
        new RegisterPage(driver).fillRegisterForm(email, pwd, pwd1)
       .goToUserAccount();
        Assert.assertTrue(new ProfilePage(driver).isProfilePageDisplayed());
        new ProfilePage(driver).deleteProfile().confirmDeleteUser(pwd1);
    }

}