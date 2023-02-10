package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;
    private final By btnEnterAccount = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By btnBun = By.xpath(".//span[text()='Булки']");
    private final By btnBunClass = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]");
    private final By btnSouse = By.xpath(".//span[text()='Соусы']");
    private final By btnSouseClass = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]");
    private final By btnIngredient = By.xpath(".//span[text()='Начинки']");
    private final By btnIngredientClass = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void btnEnterAccountClick() {
        driver.findElement(btnEnterAccount).click();
    }

    public void btnBunClick() {
        driver.findElement(btnBun).click();
    }

    public void btnSouseClick() {
        driver.findElement(btnSouse).click();
    }

    public void btnIngredientClick() {
        driver.findElement(btnIngredient).click();
    }


    public String getSouseClass() {
        return driver.findElement(btnSouseClass).getAttribute("class");
    }

    public String getBunClass() {
        return driver.findElement(btnBunClass).getAttribute("class");
    }

    public String getIngredientClass() {
        return driver.findElement(btnIngredientClass).getAttribute("class");
    }

}
