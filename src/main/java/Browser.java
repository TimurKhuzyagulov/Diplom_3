import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    static final String CHROME = "CHROME";
    static final String YANDEX = "YANDEX";

    static WebDriver driver;

    public static WebDriver getDriver() {
        return driver = Browser.selectBrowser(YANDEX);
    }

    public static WebDriver selectBrowser(String browser) {
        WebDriver driver = null;
        if (browser.equals(CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(YANDEX)) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\bin\\ya\\yandexdriver.exe");
            driver = new ChromeDriver();
        }
        return driver;

    }
}

