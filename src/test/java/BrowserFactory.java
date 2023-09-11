import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
    protected WebDriver driver;

    public BrowserFactory() {
        // Не так - надо через WebDriver Manager
        this.driver = new ChromeDriver();
        // Тест конфликтов

        String result = "asdwecdzczczd";
        String test = "sdfsdf";
    }
}
