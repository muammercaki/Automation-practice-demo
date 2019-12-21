package Base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    protected static WebDriver driver;
    public static String baseUrl = "http://automationpractice.com/";
    public static String Path = "web_driver/chromedriver";


    @BeforeScenario
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        if (Platform.getCurrent().toString().contains("WIN")) {
            Path = "web_driver/chromedriver.exe";
        }
        System.setProperty("webdriver.chrome.driver", Path);
        driver = new ChromeDriver(options);
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @AfterScenario
    public void tearDown() {
        driver.quit();
    }
}
