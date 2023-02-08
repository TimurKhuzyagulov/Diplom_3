package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigatePanelPage {
    private final WebDriver driver;
    private final By btnPersonalAccount = By.xpath(".//p[text()='Личный Кабинет']");
    private final By btnConstructor = By.xpath(".//p[text()='Конструктор']");
    private final By btnLogo = By.className("AppHeader_header__logo__2D0X2");

    public NavigatePanelPage(WebDriver driver) {
        this.driver = driver;
    }

    public void btnPersonalAccountClick() {
        driver.findElement(btnPersonalAccount).click();
    }

    public void btnConstructorClick() {
        driver.findElement(btnConstructor).click();
    }

    public void btnLogoClick() {
        driver.findElement(btnLogo).click();
    }
}
