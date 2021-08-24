package oscar.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.HomePage;
import oscar.pages.ProfilePage;
import oscar.pages.RegisterPage;

public class ProfilePageTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).clickOnLoginOrRegisterBtn();
        new RegisterPage(driver).fillLoginForm("Kuznetsov3@mail.ru", "Kuz35512$%");
    }

    @Test
    public void existedUserChangePasswordTest() {
    new ProfilePage(driver).userAccountPreview().changePassword().typeOldPassword("Kuz35512$%")
            .typeNewPassword1("Kuz35512$").typeNewPassword2("Kuz35512$").saveChangedPassword();
    Assert.assertTrue(new ProfilePage(driver).isPasswordChangedMessageAppears());
    }

    @Test
    public void editProfileTest() {
        new ProfilePage(driver).userAccountPreview().pressEditProfileBtn()
        .editProfile("Ivan", "Kuznetsov", "Kuznetsov@gmail.com")
        .isConfirmationMessageAppears();

        String eMail;
        eMail = new ProfilePage(driver).getEmail();
        System.out.println(eMail);
        Assert.assertEquals(new ProfilePage(driver), "Kuznetsov@gmail.com");
    }
}
