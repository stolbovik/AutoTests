package Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
/**
* Базовый класс для всех тестов
*/
abstract public class BaseTest {

    private final String URL = "https://ok.ru";

    /**
     * Инициализация браузера
     */
    public void init() {
        WebDriverManager.edgedriver().setup();
        Configuration.browser = "edge";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Selenide.open(URL);
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
