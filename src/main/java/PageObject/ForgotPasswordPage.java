package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;

    private final By btnEnterAccount = By.className("Auth_link__1fOlj");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void btnEnterAccountClick() {
        driver.findElement(btnEnterAccount).click();
    }
}
