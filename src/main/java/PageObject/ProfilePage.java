package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private final WebDriver driver;

    private final By btnExit = By.xpath(".//button[text()='Выход']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }


    public void btnExitClick() {
        driver.findElement(btnExit).click();
    }
}
