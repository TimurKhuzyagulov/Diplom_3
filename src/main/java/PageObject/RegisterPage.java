package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private final WebDriver driver;

    private final By nameField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private final By emailField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private final By passwordField = By.xpath(".//input[@name='Пароль']");
    private final By btnRegister = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By msgErrorShortPassword = By.xpath(".//p[text()='Некорректный пароль']");
    private final By btnEnterAccount = By.xpath(".//a[text()='Войти']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void btnRegisterClick() {
        driver.findElement(btnRegister).click();
    }

    public boolean msgErrorShortPasswordShould() {
        return driver.findElement(msgErrorShortPassword).isDisplayed();
    }

    public void btnEnterAccountClick() {
        driver.findElement(btnEnterAccount).click();
    }
}
