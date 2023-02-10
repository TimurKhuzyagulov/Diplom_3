import PageObject.MainPage;
import forAPI.SpecificationAPI;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class goChapterTest {
    private final WebDriver driver = Browser.getDriver();

    MainPage mainPage = new MainPage(driver);

    @Before
    public void beforeTest() {
        driver.get(SpecificationAPI.BASE_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
    }

    @After
    public void afterTest() {
        driver.quit();
    }

    @Test
    @DisplayName("Переключение в раздел Соусы")
    @Description("Проверка переключения в раздел Соусы")
    public void goChapterSouseTest() {
        mainPage.btnSouseClick();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
        Assert.assertEquals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect", mainPage.getSouseClass());
    }

    @Test
    @DisplayName("Перелючение в раздел Булочки")
    @Description("Проверка выбора раздела Булочки")
    public void goChapterBunTest() {
        Assert.assertEquals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect", mainPage.getBunClass());
    }

    @Test
    @DisplayName("Переключение в раздел Ингредиенты")
    @Description("Проверка переключения в раздел Ингредиенты")
    public void goIngredientBunTest() {
        mainPage.btnIngredientClick();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
        Assert.assertEquals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect", mainPage.getIngredientClass());
    }

}
