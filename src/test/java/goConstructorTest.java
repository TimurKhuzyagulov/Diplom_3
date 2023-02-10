import PageObject.LoginPage;
import PageObject.NavigatePanelPage;
import forAPI.SpecificationAPI;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class goConstructorTest {


    private final WebDriver driver = Browser.getDriver();

    LoginPage loginPage = new LoginPage(driver);
    NavigatePanelPage navigatePanelPage = new NavigatePanelPage(driver);


    @Before
    public void beforeTest() {
        driver.get(SpecificationAPI.BASE_URL);
    }

    @After
    public void afterTest() {
        driver.quit();
    }

    @Test
    @DisplayName("Переход в консутрктор, через кнопку Конструктор")
    @Description("Проверка перехода в консутрктор, через кнопку Конструктор")
    public void goConstructorClickCostructorTest() {
        navigatePanelPage.btnPersonalAccountClick();
        loginPage.setLoginPageDefoultUser();
        navigatePanelPage.btnPersonalAccountClick();
        navigatePanelPage.btnConstructorClick();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход в консутрктор, через логитип")
    @Description("Проверка перехода в консутрктор, через логотип")
    public void goConstructorClickLogoTest() {
        navigatePanelPage.btnPersonalAccountClick();
        loginPage.setLoginPageDefoultUser();
        navigatePanelPage.btnPersonalAccountClick();
        navigatePanelPage.btnLogoClick();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

}
