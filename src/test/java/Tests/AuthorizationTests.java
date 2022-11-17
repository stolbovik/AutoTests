package Tests;

import Pages.LoginPage;
import Pages.LentaPage;
import org.junit.Assert;
import org.junit.Test;
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
    private final String LOGIN = "technoPol4";
    private final String PASSWORD = "technoPolis2022";
    private final String NAME_OF_ERROR_DIV = "//div[@class='input-e login_error']";
    private final String ERROR_MESSAGE = "Неправильно указан логин и/или пароль";
    private final String NOT_PASSWORD_MESSAGE = "Введите пароль";
    private final String NOT_LOGIN_MESSAGE = "Введите логин";
    private final String USER_NAME = "technoPol4 technoPol4";
    private final String TAG_BAD_LOGIN = "BadLogin";
    private final String TAG_BAD_PASSWORD = "BadPassword";
    private final String TAG_WITH_ENTER = "WithEnter";
    private final String TAG_WITH_BUTTON = "WithButton";
    private final String TAG_GOOD_TEST = "GoodTest";


    /**
     * Проверка неверно введённого логина
     */
    @Test
    @Tag(TAG_BAD_LOGIN)
    @Tag(TAG_WITH_ENTER)
    @DisplayName("Bad login with enter")
    public void checkBadLoginWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN + "error")
                .setPasswordOnBlock(PASSWORD)
                .pressEnter();
        Assert.assertEquals("Bad login with enter don't work",
                ERROR_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV));
    }

    @Test
    @Tag(TAG_BAD_LOGIN)
    @Tag(TAG_WITH_BUTTON)
    @Tag(TAG_WITH_BUTTON)
    @DisplayName("Bad login with button")
    public void checkBadLoginWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN + "error")
                .setPasswordOnBlock(PASSWORD)
                .pressInputButton();
        Assert.assertEquals("Bad login with button don't work",
                ERROR_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV));
    }

    /**
     * Проверка неверно введённого пароля
     */
    @Test
    @Tag(TAG_BAD_PASSWORD)
    @Tag(TAG_WITH_ENTER)
    @Tag(TAG_WITH_BUTTON)
    @DisplayName("Bad password with enter")
    public void checkBadPasswordWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN)
                .setPasswordOnBlock(PASSWORD + "error")
                .pressEnter();
        Assert.assertEquals("Bad password with enter don't work",
                ERROR_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV));
    }

    @Test
    @Tag(TAG_BAD_PASSWORD)
    @Tag(TAG_WITH_BUTTON)
    @DisplayName("Bad password with button")
    public void checkBadPasswordWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN)
                .setPasswordOnBlock(PASSWORD + "error")
                .pressInputButton();
        Assert.assertEquals("Bad password with button don't work",
                ERROR_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV));
    }
    /**
     * Проверка неверно введённых пароля и логина
     */
    @Test
    @Tag(TAG_BAD_LOGIN)
    @Tag(TAG_BAD_PASSWORD)
    @Tag(TAG_WITH_ENTER)
    @DisplayName("Bad login and password with enter")
    public void checkBadPasswordAndLoginWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN + "error")
                .setPasswordOnBlock(PASSWORD + "error")
                .pressEnter();
        Assert.assertEquals("Bad login and password with enter don't work",
                ERROR_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV));
    }

    @Test
    @Tag(TAG_BAD_LOGIN)
    @Tag(TAG_BAD_PASSWORD)
    @Tag(TAG_WITH_BUTTON)
    @DisplayName("Bad login and password with button")
    public void checkBadPasswordAndLoginWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN + "error")
                .setPasswordOnBlock(PASSWORD + "error")
                .pressInputButton();
        Assert.assertEquals("Bad login and password with button don't work",
                ERROR_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV));
    }
    /**
     *
     * Проверка корректно введённых данных
     */
    @Test
    @Tag(TAG_WITH_ENTER)
    @Tag(TAG_GOOD_TEST)
    @DisplayName("Good logging with enter")
    public void checkGoodLoggingWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN)
                .setPasswordOnBlock(PASSWORD)
                .pressEnter();
        Assert.assertEquals("Good logging with enter don't work",
                USER_NAME, new LentaPage().getUserName());
    }

    @Test
    @Tag(TAG_WITH_ENTER)
    @Tag(TAG_GOOD_TEST)
    @Disabled("Old Version Of Test")
    public void checkGoodLoggingWithEnterOldVersion() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN);
        loginPage.setPasswordOnBlock(PASSWORD);
        loginPage.pressEnter();
        Assert.assertEquals("Good logging with enter don't work",
                USER_NAME, new LentaPage().getUserName());
    }

    @Test
    @Tag(TAG_WITH_BUTTON)
    @Tag(TAG_GOOD_TEST)
    @DisplayName("Good logging with button")
    public void checkGoodLoggingWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN)
                .setPasswordOnBlock(PASSWORD)
                .pressInputButton();
        Assert.assertEquals("Good logging with button don't work",
                USER_NAME, new LentaPage().getUserName());
    }

    /*
     * Проверка авторизации с пустым полем "Логин"
     */
    @Test
    @Tag(TAG_BAD_LOGIN)
    @Tag(TAG_WITH_ENTER)
    @DisplayName("Empty login with enter")
    public void checkEmptyLoginWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.setPasswordOnBlock(PASSWORD)
                .pressEnter();
        Assert.assertEquals("Empty login with enter don't work",
                NOT_LOGIN_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV));
    }

    @Test
    @Tag(TAG_BAD_LOGIN)
    @Tag(TAG_WITH_BUTTON)
    @DisplayName("Empty login with button")
    public void checkEmptyLoginWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.setPasswordOnBlock(PASSWORD)
                .pressInputButton();
        Assert.assertEquals("Empty login with button don't work",
                NOT_LOGIN_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV));
    }

    /*
     * Проверка авторизации с пустым полем "Пароль"
     */
    @Test
    @Tag(TAG_BAD_PASSWORD)
    @Tag(TAG_WITH_ENTER)
    @DisplayName("Empty password with enter")
    public void checkEmptyPasswordWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN)
                .pressEnter();
        Assert.assertEquals("Empty password with enter don't work",
                NOT_PASSWORD_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV));
    }

    @Test
    @Tag(TAG_BAD_PASSWORD)
    @Tag(TAG_WITH_BUTTON)
    @DisplayName("Empty password with button")
    public void checkEmptyPasswordWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN)
                .pressInputButton();
        Assert.assertEquals("Empty password with button don't work",
                NOT_PASSWORD_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV));
    }

    /*
     * Проверка авторизации с пустыми полями "Пароль" и "Логин"
     */
    @Test
    @Tag(TAG_BAD_LOGIN)
    @Tag(TAG_BAD_PASSWORD)
    @Tag(TAG_WITH_ENTER)
    @DisplayName("Empty login and password with enter")
    public void checkEmptyPasswordAndLoginWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.pressEnter();
        Assert.assertEquals("Empty login and password with enter don't work",
                NOT_LOGIN_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV));
    }

    @Test
    @Tag(TAG_BAD_LOGIN)
    @Tag(TAG_BAD_PASSWORD)
    @Tag(TAG_WITH_BUTTON)
    @DisplayName("Empty login and password with button")
    public void checkEmptyPasswordAndLoginWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.pressInputButton();
        Assert.assertEquals("Empty login and password with button don't work",
                NOT_LOGIN_MESSAGE, loginPage.getError(NAME_OF_ERROR_DIV));
    }

}
