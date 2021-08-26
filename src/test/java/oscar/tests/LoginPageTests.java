package oscar.tests;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.HomePage;
import oscar.pages.ProfilePage;
import oscar.pages.RegisterPage;

public class LoginPageTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).clickOnLoginOrRegisterBtn();
    }

    @Test(priority = 1, groups = {"functional"})
    public void loginExistedUserNegativeTestWithWrongEmail() {
        new RegisterPage(driver).fillLoginForm("Sidoro@mail.ru", "Sidor12345$");
        Assert.assertTrue(new HomePage(driver).isErrorMessageAppears());
    }
    @Test(priority = 2, groups = {"functional"})
    public void loginExistedUserNegativeTestWithWrongPassword() {
        new RegisterPage(driver).fillLoginForm("Sidorov@mail.ru", "123");
        Assert.assertTrue(new HomePage(driver).isErrorMessageAppears());
    }
    @Test(priority = 3, groups = {"functional"})
    public void checkEmailInUserProfile() {
        new RegisterPage(driver).fillLoginForm("Sidorov@mail.ru", "Sidor12345$");
        new ProfilePage(driver).userAccountPreview();
        String userEmail;
        userEmail = new ProfilePage(driver).getUserEmail();
        System.out.println(userEmail);
        Assert.assertEquals(new ProfilePage(driver).getUserEmail(), "Sidorov@mail.ru" );
    }
}
