import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {

    static final String CHROME = "CHROME";
    static final String YANDEX = "YANDEX";

    public static WebDriver selectBrowser(String browser) {
        WebDriver driver = null;
        if (browser.equals(CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(YANDEX)) {
            System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\bin\\ya\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\Тимур\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
            driver = new ChromeDriver(options);
        }
        return driver;

    }
}

