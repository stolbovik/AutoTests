package Tests;

import Pages.LoginPage;
import Pages.LentaPage;
import org.junit.Assert;
import org.junit.Test;
/*
* Тесты для страници авторизации
*/
public class LoginTests extends BaseTest{
    /**
     * Данные для работы тестов
     */
    private final String LOGIN = "technoPol4";
    private final String PASSWORD = "technoPolis2022";
    private final String NAME_OF_ERROR_DIV = "//div[@class='input-e login_error']";
    private final String errorMessege = "Неправильно указан логин и/или пароль";
    private final String notPasswordMessege = "Введите пароль";
    private final String notLoginMessege = "Введите логин";
    private final String userName = "technoPol4 technoPol4";


    /**
     * Проверка неверно введённого логина
     */
    @Test
    public void checkBadLoginWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN + "error")
                .setPasswordOnBlock(PASSWORD)
                .pressEnter();
        Assert.assertEquals("Bad login with enter don't work", errorMessege, loginPage.getError(NAME_OF_ERROR_DIV));
    }

    @Test
    public void checkBadLoginWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN + "error")
                .setPasswordOnBlock(PASSWORD)
                .pressInputButton();
        Assert.assertEquals("Bad login with button don't work", errorMessege, loginPage.getError(NAME_OF_ERROR_DIV));
    }

    /**
     * Проверка неверно введённого пароля
     */
    @Test
    public void checkBadPasswordWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN)
                .setPasswordOnBlock(PASSWORD + "error")
                .pressEnter();
        Assert.assertEquals("Bad password with enter don't work", errorMessege, loginPage.getError(NAME_OF_ERROR_DIV));
    }

    @Test
    public void checkBadPasswordWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN)
                .setPasswordOnBlock(PASSWORD + "error")
                .pressInputButton();
        Assert.assertEquals("Bad password with button don't work", errorMessege, loginPage.getError(NAME_OF_ERROR_DIV));
    }
    /**
     * Проверка неверно введённых пароля и логина
     */
    @Test
    public void checkBadPasswordAndLoginWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN + "error")
                .setPasswordOnBlock(PASSWORD + "error")
                .pressEnter();
        Assert.assertEquals("Bad login and password with enter don't work",
                errorMessege, loginPage.getError(NAME_OF_ERROR_DIV));
    }

    @Test
    public void checkBadPasswordAndLoginWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN + "error")
                .setPasswordOnBlock(PASSWORD + "error")
                .pressInputButton();
        Assert.assertEquals("Bad login and password with button don't work",
                errorMessege, loginPage.getError(NAME_OF_ERROR_DIV));
    }
    /**
     *
     * Проверка корректно введённых данных
     */
    @Test
    public void checkGoodLoggingWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN)
                .setPasswordOnBlock(PASSWORD)
                .pressEnter();
        Assert.assertEquals("Good logging with enter don't work", userName, new LentaPage().getUserName());
    }

    @Test
    public void checkGoodLoggingWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN)
                .setPasswordOnBlock(PASSWORD)
                .pressInputButton();
        Assert.assertEquals("Good logging with button don't work", userName, new LentaPage().getUserName());
    }

    /*
     * Проверка авторизации с пустым полем "Логин"
     */
    @Test
    public void checkEmptyLoginWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.setPasswordOnBlock(PASSWORD)
                .pressEnter();
        Assert.assertEquals("Empty login with enter don't work", notLoginMessege, loginPage.getError(NAME_OF_ERROR_DIV));
    }

    @Test
    public void checkEmptyLoginWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.setPasswordOnBlock(PASSWORD)
                .pressInputButton();
        Assert.assertEquals("Empty login with button don't work", notLoginMessege, loginPage.getError(NAME_OF_ERROR_DIV));
    }

    /*
     * Проверка авторизации с пустым полем "Пароль"
     */
    @Test
    public void checkEmptyPasswordWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN)
                .pressEnter();
        Assert.assertEquals("Empty password with enter don't work", notPasswordMessege, loginPage.getError(NAME_OF_ERROR_DIV));
    }

    @Test
    public void checkEmptyPasswordWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginOnBlock(LOGIN)
                .pressInputButton();
        Assert.assertEquals("Empty password with button don't work", notPasswordMessege, loginPage.getError(NAME_OF_ERROR_DIV));
    }

    /*
     * Проверка авторизации с пустыми полями "Пароль" и "Логин"
     */
    @Test
    public void checkEmptyPasswordAndLoginWithEnter() {
        LoginPage loginPage = new LoginPage();
        loginPage.pressEnter();
        Assert.assertEquals("Empty login and password with enter don't work",
                notLoginMessege, loginPage.getError(NAME_OF_ERROR_DIV));
    }

    @Test
    public void checkEmptyPasswordAndLoginWithButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.pressInputButton();
        Assert.assertEquals("Empty login and password with button don't work",
                notLoginMessege, loginPage.getError(NAME_OF_ERROR_DIV));
    }

}
