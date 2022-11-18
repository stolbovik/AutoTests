package Tests;

import Pages.LoginObject;
import Pages.LentaObject;
import Resources.Tags;
import Resources.TestBotInfo;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

/*
* Тесты для страници авторизации
*/
@Tag(Tags.TAG_AUTHORIZATION_TESTS)
@DisplayName("Authorization Tests")
public class AuthorizationTests extends BaseTest{
    /**
     * Данные для работы тестов
     */
    private final TestBotInfo TEST_BOT_INFO = new TestBotInfo("technoPol4", "technoPolis2022",
            "technoPol4", "technoPol4");
    private final String NAME_OF_ERROR_DIV = "//div[@class='input-e login_error']";
    private final String ERROR_MESSAGE = "Неправильно указан логин и/или пароль";
    private final String NOT_PASSWORD_MESSAGE = "Введите пароль";
    private final String NOT_LOGIN_MESSAGE = "Введите логин";

    /**
     * Проверка неверно введённого логина
     */
    @Test
    @Tag(Tags.TAG_BAD_LOGIN)
    @Tag(Tags.TAG_LOGGING_WITH_ENTER)
    @DisplayName("Bad login with enter")
    public void checkBadLoginWithEnter() {
        LoginObject loginPage = new LoginObject();
        loginPage.setLoginOnBlock(TEST_BOT_INFO.getLOGIN() + "error")
                .setPasswordOnBlock(TEST_BOT_INFO.getPASSWORD())
                .pressEnter();
        Assertions.assertEquals(ERROR_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Bad login with enter don't work");
    }

    @Test
    @Tag(Tags.TAG_BAD_LOGIN)
    @Tag(Tags.TAG_LOGGING_WITH_BUTTON)
    @Tag(Tags.TAG_LOGGING_WITH_BUTTON)
    @DisplayName("Bad login with button")
    public void checkBadLoginWithButton() {
        LoginObject loginPage = new LoginObject();
        loginPage.setLoginOnBlock(TEST_BOT_INFO.getLOGIN() + "error")
                .setPasswordOnBlock(TEST_BOT_INFO.getPASSWORD())
                .pressInputButton();
        Assertions.assertEquals(ERROR_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Bad login with button don't work");
    }

    /**
     * Проверка неверно введённого пароля
     */
    @Test
    @Tag(Tags.TAG_BAD_PASSWORD)
    @Tag(Tags.TAG_LOGGING_WITH_ENTER)
    @Tag(Tags.TAG_LOGGING_WITH_BUTTON)
    @DisplayName("Bad password with enter")
    public void checkBadPasswordWithEnter() {
        LoginObject loginPage = new LoginObject();
        loginPage.setLoginOnBlock(TEST_BOT_INFO.getLOGIN())
                .setPasswordOnBlock(TEST_BOT_INFO.getPASSWORD() + "error")
                .pressEnter();
        Assertions.assertEquals(ERROR_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Bad password with enter don't work");
    }

    @Test
    @Tag(Tags.TAG_BAD_PASSWORD)
    @Tag(Tags.TAG_LOGGING_WITH_BUTTON)
    @DisplayName("Bad password with button")
    public void checkBadPasswordWithButton() {
        LoginObject loginPage = new LoginObject();
        loginPage.setLoginOnBlock(TEST_BOT_INFO.getLOGIN())
                .setPasswordOnBlock(TEST_BOT_INFO.getPASSWORD() + "error")
                .pressInputButton();
        Assertions.assertEquals(ERROR_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Bad password with button don't work");
    }
    /**
     * Проверка неверно введённых пароля и логина
     */
    @Test
    @Tag(Tags.TAG_BAD_LOGIN)
    @Tag(Tags.TAG_BAD_PASSWORD)
    @Tag(Tags.TAG_LOGGING_WITH_ENTER)
    @DisplayName("Bad login and password with enter")
    public void checkBadPasswordAndLoginWithEnter() {
        LoginObject loginPage = new LoginObject();
        loginPage.setLoginOnBlock(TEST_BOT_INFO.getLOGIN() + "error")
                .setPasswordOnBlock(TEST_BOT_INFO.getPASSWORD() + "error")
                .pressEnter();
        Assertions.assertEquals(ERROR_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Bad login and password with enter don't work");
    }

    @Test
    @Tag(Tags.TAG_BAD_LOGIN)
    @Tag(Tags.TAG_BAD_PASSWORD)
    @Tag(Tags.TAG_LOGGING_WITH_BUTTON)
    @DisplayName("Bad login and password with button")
    public void checkBadPasswordAndLoginWithButton() {
        LoginObject loginPage = new LoginObject();
        loginPage.setLoginOnBlock(TEST_BOT_INFO.getLOGIN() + "error")
                .setPasswordOnBlock(TEST_BOT_INFO.getPASSWORD() + "error")
                .pressInputButton();
        Assertions.assertEquals(ERROR_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Bad login and password with button don't work");
    }
    /**
     *
     * Проверка корректно введённых данных
     */
    @Test
    @Tag(Tags.TAG_LOGGING_WITH_ENTER)
    @Tag(Tags.TAG_GOOD_LOGGING)
    @DisplayName("Good logging with enter")
    public void checkGoodLoggingWithEnter() {
        LoginObject loginPage = new LoginObject();
        loginPage.setLoginOnBlock(TEST_BOT_INFO.getLOGIN())
                .setPasswordOnBlock(TEST_BOT_INFO.getPASSWORD())
                .pressEnter().checkPage();
        Assertions.assertEquals(TEST_BOT_INFO.getFirstName() + ' ' + TEST_BOT_INFO.getLastName(),
                new LentaObject("//*[@class='navigation']").getUserName(), "Good logging with enter don't work");
    }

    @Test
    @Tag(Tags.TAG_LOGGING_WITH_ENTER)
    @Tag(Tags.TAG_GOOD_LOGGING)
    @Disabled("Old Version Of Test")
    public void checkGoodLoggingWithEnterOldVersion() {
        LoginObject loginPage = new LoginObject();
        loginPage.setLoginOnBlock(TEST_BOT_INFO.getLOGIN());
        loginPage.setPasswordOnBlock(TEST_BOT_INFO.getPASSWORD());
        loginPage.pressEnter();
        Assertions.assertEquals(TEST_BOT_INFO.getFirstName() + ' ' + TEST_BOT_INFO.getLastName(),
                new LentaObject("//*[@class='navigation']").getUserName(), "Good logging with enter don't work");
    }

    @Test
    @Tag(Tags.TAG_LOGGING_WITH_BUTTON)
    @Tag(Tags.TAG_GOOD_LOGGING)
    @DisplayName("Good logging with button")
    public void checkGoodLoggingWithButton() {
        LoginObject loginPage = new LoginObject();
        loginPage.setLoginOnBlock(TEST_BOT_INFO.getLOGIN())
                .setPasswordOnBlock(TEST_BOT_INFO.getPASSWORD())
                .pressInputButton().checkPage();
        Assertions.assertEquals(TEST_BOT_INFO.getFirstName() + ' ' + TEST_BOT_INFO.getLastName(),
                new LentaObject("//*[@class='navigation']").getUserName(), "Good logging with button don't work");
    }

    /*
     * Проверка авторизации с пустым полем "Логин"
     */
    @Test
    @Tag(Tags.TAG_BAD_LOGIN)
    @Tag(Tags.TAG_LOGGING_WITH_ENTER)
    @DisplayName("Empty login with enter")
    public void checkEmptyLoginWithEnter() {
        LoginObject loginPage = new LoginObject();
        loginPage.setPasswordOnBlock(TEST_BOT_INFO.getPASSWORD())
                .pressEnter();
        Assertions.assertEquals(NOT_LOGIN_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Empty login with enter don't work");
    }

    @Test
    @Tag(Tags.TAG_BAD_LOGIN)
    @Tag(Tags.TAG_LOGGING_WITH_BUTTON)
    @DisplayName("Empty login with button")
    public void checkEmptyLoginWithButton() {
        LoginObject loginPage = new LoginObject();
        loginPage.setPasswordOnBlock(TEST_BOT_INFO.getPASSWORD())
                .pressInputButton();
        Assertions.assertEquals(NOT_LOGIN_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Empty login with button don't work");
    }

    /*
     * Проверка авторизации с пустым полем "Пароль"
     */
    @Test
    @Tag(Tags.TAG_BAD_PASSWORD)
    @Tag(Tags.TAG_LOGGING_WITH_ENTER)
    @DisplayName("Empty password with enter")
    public void checkEmptyPasswordWithEnter() {
        LoginObject loginPage = new LoginObject();
        loginPage.setLoginOnBlock(TEST_BOT_INFO.getLOGIN())
                .pressEnter();
        Assertions.assertEquals(NOT_PASSWORD_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Empty password with enter don't work");
    }

    @Test
    @Tag(Tags.TAG_BAD_PASSWORD)
    @Tag(Tags.TAG_LOGGING_WITH_BUTTON)
    @DisplayName("Empty password with button")
    public void checkEmptyPasswordWithButton() {
        LoginObject loginPage = new LoginObject();
        loginPage.setLoginOnBlock(TEST_BOT_INFO.getLOGIN())
                .pressInputButton();
        Assertions.assertEquals(NOT_PASSWORD_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Empty password with button don't work");
    }

    /*
     * Проверка авторизации с пустыми полями "Пароль" и "Логин"
     */
    @Test
    @Tag(Tags.TAG_BAD_LOGIN)
    @Tag(Tags.TAG_BAD_PASSWORD)
    @Tag(Tags.TAG_LOGGING_WITH_ENTER)
    @DisplayName("Empty login and password with enter")
    public void checkEmptyPasswordAndLoginWithEnter() {
        LoginObject loginPage = new LoginObject();
        loginPage.pressEnter();
        Assertions.assertEquals(NOT_LOGIN_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Empty login and password with enter don't work");
    }

    @Test
    @Tag(Tags.TAG_BAD_LOGIN)
    @Tag(Tags.TAG_BAD_PASSWORD)
    @Tag(Tags.TAG_LOGGING_WITH_BUTTON)
    @DisplayName("Empty login and password with button")
    public void checkEmptyPasswordAndLoginWithButton() {
        LoginObject loginPage = new LoginObject();
        loginPage.pressInputButton();
        Assertions.assertEquals(NOT_LOGIN_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Empty login and password with button don't work");
    }

}
