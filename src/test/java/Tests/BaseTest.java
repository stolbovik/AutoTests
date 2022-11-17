package Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runners.Parameterized;

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

    @BeforeEach
    public void initTest() {
        init();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
