import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
    protected WebDriver driver;

    public BrowserFactory() {
        this.driver = new ChromeDriver();
    }
}
