import PageObject.LoginPage;
import PageObject.NavigatePanelPage;
import PageObject.ProfilePage;
import forAPI.SpecificationAPI;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class exitFromPersonalAccountTest {

    private final WebDriver driver = Browser.getDriver();

    LoginPage loginPage = new LoginPage(driver);
    NavigatePanelPage navigatePanelPage = new NavigatePanelPage(driver);
    ProfilePage profilePage = new ProfilePage(driver);


    @Before
    public void setUp() {
        driver.get(SpecificationAPI.BASE_URL);
    }

    @After
    public void afterTest() {
        driver.quit();
    }

    @Test
    @DisplayName("Выход из личного кабинета")
    @Description("Проверка выхода из личного кабинета")
    public void exitFromPersonalAccountTest() {

        navigatePanelPage.btnPersonalAccountClick();
        loginPage.setLoginPageDefoultUser();
        navigatePanelPage.btnPersonalAccountClick();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        profilePage.btnExitClick();
        navigatePanelPage.btnPersonalAccountClick();

        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl());

    }

}
