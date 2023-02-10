import PageObject.LoginPage;
import PageObject.NavigatePanelPage;
import PageObject.RegisterPage;
import forAPI.DeleteUserAPI;
import forAPI.SpecificationAPI;
import forAPI.User;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class registrTest {

    User userTestSuccess = new User("timTest@mail.ru", "1232212", "timName");
    User userTestShortPassword = new User("testShort@mail.ru", "1234", "testShort");
    private final WebDriver driver = Browser.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    RegisterPage registrPage = new RegisterPage(driver);
    NavigatePanelPage navigatePanelPage = new NavigatePanelPage(driver);

    @Before
    public void beforeTest() {
        driver.get(SpecificationAPI.BASE_URL);
        navigatePanelPage.btnPersonalAccountClick();
        loginPage.btnRegistrClick();
    }

    @After
    public void afterTest() {
        driver.quit();
    }

    @Test
    @DisplayName("Успешная регистрация пользователя")
    @Description("Проверяем успешной регистрации пользователя")
    public void successRegistrTest() {

        registrPage.setNameField(userTestSuccess.getName());
        registrPage.setEmailField(userTestSuccess.getEmail());
        registrPage.setPasswordField(userTestSuccess.getPassword());
        registrPage.btnRegisterClick();
        DeleteUserAPI.deleteUser(userTestSuccess);
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Регистрация пользователя с коротким паролем")
    @Description("Проверяем регистрацию пользователя с коротким паролем")
    public void registrWithShortPassword() {
        registrPage.setNameField(userTestShortPassword.getName());
        registrPage.setEmailField(userTestShortPassword.getEmail());
        registrPage.setPasswordField(userTestShortPassword.getPassword());
        registrPage.btnRegisterClick();
        Assert.assertTrue(registrPage.msgErrorShortPasswordShould());

    }


}
