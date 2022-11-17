package Tests;

import Pages.LoginPage;
import Pages.LentaPage;
import Resources.Tags;
import Resources.TestBotInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

/*
* Тесты для страници авторизации
*/
@Tag("AuthorizationTests")
@DisplayName("Authorization Tests")
public class AuthorizationTests extends BaseTest{
    /**
     * Данные для работы тестов
     */
    private final TestBotInfo testBotInfo = new TestBotInfo("technoPol4", "technoPolis2022",
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
    @Tag(Tags.TAG_WITH_ENTER)
    @DisplayName("Bad login with enter")
    public void checkBadLoginWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(testBotInfo.getLogin() + "error")
                .setPasswordOnBlock(testBotInfo.getPassword())
                .pressEnter();
        Assertions.assertEquals(ERROR_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Bad login with enter don't work");
    }

    @Test
    @Tag(Tags.TAG_BAD_LOGIN)
    @Tag(Tags.TAG_WITH_BUTTON)
    @Tag(Tags.TAG_WITH_BUTTON)
    @DisplayName("Bad login with button")
    public void checkBadLoginWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(testBotInfo.getLogin() + "error")
                .setPasswordOnBlock(testBotInfo.getPassword())
                .pressInputButton();
        Assertions.assertEquals(ERROR_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Bad login with button don't work");
    }

    /**
     * Проверка неверно введённого пароля
     */
    @Test
    @Tag(Tags.TAG_BAD_PASSWORD)
    @Tag(Tags.TAG_WITH_ENTER)
    @Tag(Tags.TAG_WITH_BUTTON)
    @DisplayName("Bad password with enter")
    public void checkBadPasswordWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(testBotInfo.getLogin())
                .setPasswordOnBlock(testBotInfo.getPassword() + "error")
                .pressEnter();
        Assertions.assertEquals(ERROR_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Bad password with enter don't work");
    }

    @Test
    @Tag(Tags.TAG_BAD_PASSWORD)
    @Tag(Tags.TAG_WITH_BUTTON)
    @DisplayName("Bad password with button")
    public void checkBadPasswordWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(testBotInfo.getLogin())
                .setPasswordOnBlock(testBotInfo.getPassword() + "error")
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
    @Tag(Tags.TAG_WITH_ENTER)
    @DisplayName("Bad login and password with enter")
    public void checkBadPasswordAndLoginWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(testBotInfo.getLogin() + "error")
                .setPasswordOnBlock(testBotInfo.getPassword() + "error")
                .pressEnter();
        Assertions.assertEquals(ERROR_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Bad login and password with enter don't work");
    }

    @Test
    @Tag(Tags.TAG_BAD_LOGIN)
    @Tag(Tags.TAG_BAD_PASSWORD)
    @Tag(Tags.TAG_WITH_BUTTON)
    @DisplayName("Bad login and password with button")
    public void checkBadPasswordAndLoginWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(testBotInfo.getLogin() + "error")
                .setPasswordOnBlock(testBotInfo.getPassword() + "error")
                .pressInputButton();
        Assertions.assertEquals(ERROR_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Bad login and password with button don't work");
    }
    /**
     *
     * Проверка корректно введённых данных
     */
    @Test
    @Tag(Tags.TAG_WITH_ENTER)
    @Tag(Tags.TAG_GOOD_TEST)
    @DisplayName("Good logging with enter")
    public void checkGoodLoggingWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(testBotInfo.getLogin())
                .setPasswordOnBlock(testBotInfo.getPassword())
                .pressEnter().checkPage();
        Assertions.assertEquals(testBotInfo.getFirstName() + ' ' + testBotInfo.getLastName(),
                new LentaPage().getUserName(), "Good logging with enter don't work");
    }

    @Test
    @Tag(Tags.TAG_WITH_ENTER)
    @Tag(Tags.TAG_GOOD_TEST)
    @Disabled("Old Version Of Test")
    public void checkGoodLoggingWithEnterOldVersion() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(testBotInfo.getLogin());
        loginPage.setPasswordOnBlock(testBotInfo.getPassword());
        loginPage.pressEnter();
        Assertions.assertEquals(testBotInfo.getFirstName() + ' ' + testBotInfo.getLastName(),
                new LentaPage().getUserName(), "Good logging with enter don't work");
    }

    @Test
    @Tag(Tags.TAG_WITH_BUTTON)
    @Tag(Tags.TAG_GOOD_TEST)
    @DisplayName("Good logging with button")
    public void checkGoodLoggingWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(testBotInfo.getLogin())
                .setPasswordOnBlock(testBotInfo.getPassword())
                .pressInputButton().checkPage();
        Assertions.assertEquals(testBotInfo.getFirstName() + ' ' + testBotInfo.getLastName(),
                new LentaPage().getUserName(), "Good logging with button don't work");
    }

    /*
     * Проверка авторизации с пустым полем "Логин"
     */
    @Test
    @Tag(Tags.TAG_BAD_LOGIN)
    @Tag(Tags.TAG_WITH_ENTER)
    @DisplayName("Empty login with enter")
    public void checkEmptyLoginWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.setPasswordOnBlock(testBotInfo.getPassword())
                .pressEnter();
        Assertions.assertEquals(NOT_LOGIN_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Empty login with enter don't work");
    }

    @Test
    @Tag(Tags.TAG_BAD_LOGIN)
    @Tag(Tags.TAG_WITH_BUTTON)
    @DisplayName("Empty login with button")
    public void checkEmptyLoginWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.setPasswordOnBlock(testBotInfo.getPassword())
                .pressInputButton();
        Assertions.assertEquals(NOT_LOGIN_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Empty login with button don't work");
    }

    /*
     * Проверка авторизации с пустым полем "Пароль"
     */
    @Test
    @Tag(Tags.TAG_BAD_PASSWORD)
    @Tag(Tags.TAG_WITH_ENTER)
    @DisplayName("Empty password with enter")
    public void checkEmptyPasswordWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(testBotInfo.getLogin())
                .pressEnter();
        Assertions.assertEquals(NOT_PASSWORD_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Empty password with enter don't work");
    }

    @Test
    @Tag(Tags.TAG_BAD_PASSWORD)
    @Tag(Tags.TAG_WITH_BUTTON)
    @DisplayName("Empty password with button")
    public void checkEmptyPasswordWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(testBotInfo.getLogin())
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
    @Tag(Tags.TAG_WITH_ENTER)
    @DisplayName("Empty login and password with enter")
    public void checkEmptyPasswordAndLoginWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.pressEnter();
        Assertions.assertEquals(NOT_LOGIN_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Empty login and password with enter don't work");
    }

    @Test
    @Tag(Tags.TAG_BAD_LOGIN)
    @Tag(Tags.TAG_BAD_PASSWORD)
    @Tag(Tags.TAG_WITH_BUTTON)
    @DisplayName("Empty login and password with button")
    public void checkEmptyPasswordAndLoginWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.pressInputButton();
        Assertions.assertEquals(NOT_LOGIN_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV),
                "Empty login and password with button don't work");
    }

}
