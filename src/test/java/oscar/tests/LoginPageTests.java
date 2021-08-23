package oscar.tests;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.HomePage;
import oscar.pages.RegisterPage;

public class LoginPageTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).clickOnLoginOrRegisterBtn();
    }
    @Test
    public void loginExistedUserPositiveTest() {
        new RegisterPage(driver).fillLoginForm("Kuznetsov3@mail.ru", "Kuz35512$%");
        Assert.assertTrue(new HomePage(driver).isWillkomenMessageAppears());
    }

    @Test
    public void loginExistedUserNegativeTestWithWrongEmail() {
        new RegisterPage(driver).fillLoginForm("Kuznetso@mail.ru", "Kuz35512$%");
        Assert.assertTrue(new HomePage(driver).isErrorMessageAppears());
    }
    @Test
    public void loginExistedUserNegativeTestWithWrongPassword() {
        new RegisterPage(driver).fillLoginForm("Kuznetsov3@mail.ru", "123");
        Assert.assertTrue(new HomePage(driver).isErrorMessageAppears());
    }
}
