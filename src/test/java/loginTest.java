import PageObject.*;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class loginTest {

    private final WebDriver driver = Browser.selectBrowser(Browser.CHROME);

    MainPage mainPage = new MainPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    RegisterPage registrPage = new RegisterPage(driver);
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
    NavigatePanelPage navigatePanelPage = new NavigatePanelPage(driver);

    @Before
    public void beforeTest() {
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @After
    public void afterTest(){
        driver.quit();
    }

    //Проверяем вход и переход по клику на "Личный кабинет"
    @Test
    @DisplayName("Вход в ЛК через кнопку Войти в аккаунт")
    @Description("Проверяем вход в ЛК, через кнопку Войти в аккаунт")
    public void enterToAccountFromMainPage(){
        mainPage.btnEnterAccountClick();
        loginPage.setLoginPageDefoultUser();
        navigatePanelPage.btnPersonalAccountClick();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/account", driver.getCurrentUrl().toString());
    }

    @Test
    @DisplayName("Вход в ЛК через кнопку Личный кабинет")
    @Description("Проверяем вход в ЛК, через кнопку Личный кабинет")
    public void enterToAccountFromNav(){
        navigatePanelPage.btnPersonalAccountClick();
        loginPage.setLoginPageDefoultUser();
        navigatePanelPage.btnPersonalAccountClick();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/account", driver.getCurrentUrl().toString());
    }

    @Test
    @DisplayName("Вход в ЛК через кнопку на форме Регистрации")
    @Description("Проверяем вход в ЛК, через кнопку на форме Регистрации")
    public void enterToAccountFromRegisterPage(){
        navigatePanelPage.btnPersonalAccountClick();
        loginPage.btnRegistrClick();
        registrPage.btnEnterAccountClick();
        loginPage.setLoginPageDefoultUser();
        navigatePanelPage.btnPersonalAccountClick();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/account", driver.getCurrentUrl().toString());
    }

    @Test
    @DisplayName("Вход в ЛК через кнопку на форме Восстановления пароля")
    @Description("Проверяем вход в ЛК, через кнопку на форме Восстановления пароля")
    public void enterToAccountFromForgotPasswordPage(){
        navigatePanelPage.btnPersonalAccountClick();
        loginPage.btnForgotPasswordClick();
        forgotPasswordPage.btnEnterAccountClick();
        loginPage.setLoginPageDefoultUser();
        navigatePanelPage.btnPersonalAccountClick();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/account", driver.getCurrentUrl().toString());
    }

}
