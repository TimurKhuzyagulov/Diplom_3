package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private final By emailField = By.xpath(".//input[@name='name']");
    private final By passwordField = By.xpath(".//input[@name='Пароль']");
    private final By btnLogin = By.xpath(".//button[text()='Войти']");
    private final By btnRegistr = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By btnForgotPassword = By.xpath(".//a[text()='Восстановить пароль']");



    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void btnLoginClick() {
        driver.findElement(btnLogin).click();
    }

    public void btnRegistrClick() {
        driver.findElement(btnRegistr).click();
    }

    public void btnForgotPasswordClick() {
        driver.findElement(btnForgotPassword).click();
    }

    public void setLoginPageDefoultUser() {
        setEmailField("test-dekab41@email.ru");
        setPasswordField("06078991");
        btnLoginClick();
    }

}
