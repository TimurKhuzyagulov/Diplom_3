import PageObject.LoginPage;
import PageObject.NavigatePanelPage;
import PageObject.ProfilePage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class exitFromPersonalAccountTest {

    private final String browser;

    public exitFromPersonalAccountTest(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "Для браузера: {0}")
    public static Object[][] getBrowser() {
        return new Object[][]{
                {Browser.YANDEX},
                {Browser.CHROME},
        };
    }


    @Test
    @DisplayName("Выход из личного кабинета")
    @Description("Проверка выхода из личного кабинета")
    public void exitFromPersonalAccountTest() {
        WebDriver driver = Browser.selectBrowser(browser);
        driver.get("https://stellarburgers.nomoreparties.site/");

        LoginPage loginPage = new LoginPage(driver);
        NavigatePanelPage navigatePanelPage = new NavigatePanelPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        navigatePanelPage.btnPersonalAccountClick();
        loginPage.setLoginPageDefoultUser();
        navigatePanelPage.btnPersonalAccountClick();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        profilePage.btnExitClick();
        navigatePanelPage.btnPersonalAccountClick();

        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl());

        driver.quit();
    }
}
