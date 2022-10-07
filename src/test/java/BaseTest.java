import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
/**
* Базовый класс для всех тестов
*/
abstract public class BaseTest {

    public void init() {
//        System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver.exe");
        WebDriverManager.edgedriver().setup();
        Configuration.browser = "edge";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
    }

    @Before
    public void initTest() {
        init();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
