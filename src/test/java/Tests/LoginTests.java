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
    private final String OK_BASE_URL = "https://ok.ru/dk?st.cmd=anonymMain&st.fflo=on&st.lgn=on";
    private final String LOGIN = "stolbov_svyatoslav_02@mail.ru";
    private final String PASSWORD = "f+ac5EMrAC8gq.4";
    private final String nameOfErrorDiv = "//div[@class='input-e login_error']";
    private final String errorMessege = "Неправильно указан логин и/или пароль";
    private final String notPasswordMessege = "Введите пароль";
    private final String notLoginMessege = "Введите логин";
    private final String userName = "Святослав Столбов";


    /**
     * Проверка неверно введённого логина
     */
    @Test
    public void checkBadLoginWithEnter() {
        LoginPage loginPage = new LoginPage(OK_BASE_URL);
        loginPage.setLoginOnBlock(LOGIN + "error");
        loginPage.setPasswordOnBlock(PASSWORD);
        loginPage.pressEnter();
        Assert.assertEquals(errorMessege, loginPage.getError(nameOfErrorDiv));
    }

    @Test
    public void checkBadLoginWithButton() {
        LoginPage loginPage = new LoginPage(OK_BASE_URL);
        loginPage.setLoginOnBlock(LOGIN + "error");
        loginPage.setPasswordOnBlock(PASSWORD);
        loginPage.pressInputButton();
        Assert.assertEquals(errorMessege, loginPage.getError(nameOfErrorDiv));
    }

    /**
     * Проверка неверно введённого пароля
     */
    @Test
    public void checkBadPasswordWithEnter() {
        LoginPage loginPage = new LoginPage(OK_BASE_URL);
        loginPage.setLoginOnBlock(LOGIN);
        loginPage.setPasswordOnBlock(PASSWORD + "error");
        loginPage.pressEnter();
        Assert.assertEquals(errorMessege, loginPage.getError(nameOfErrorDiv));
    }

    @Test
    public void checkBadPasswordWithButton() {
        LoginPage loginPage = new LoginPage(OK_BASE_URL);
        loginPage.setLoginOnBlock(LOGIN);
        loginPage.setPasswordOnBlock(PASSWORD + "error");
        loginPage.pressInputButton();
        Assert.assertEquals(errorMessege, loginPage.getError(nameOfErrorDiv));
    }
    /**
     * Проверка неверно введённых пароля и логина
     */
    @Test
    public void checkBadPasswordAndLoginWithEnter() {
        LoginPage loginPage = new LoginPage(OK_BASE_URL);
        loginPage.setLoginOnBlock(LOGIN + "error");
        loginPage.setPasswordOnBlock(PASSWORD + "error");
        loginPage.pressEnter();
        Assert.assertEquals(errorMessege, loginPage.getError(nameOfErrorDiv));
    }

    @Test
    public void checkBadPasswordAndLoginWithButton() {
        LoginPage loginPage = new LoginPage(OK_BASE_URL);
        loginPage.setLoginOnBlock(LOGIN + "error");
        loginPage.setPasswordOnBlock(PASSWORD + "error");
        loginPage.pressInputButton();
        Assert.assertEquals(errorMessege, loginPage.getError(nameOfErrorDiv));
    }
    /**
     *
     * Проверка корректно введённых данных
     */
    @Test
    public void checkGoodLoggingWithEnter() {
        LoginPage loginPage = new LoginPage(OK_BASE_URL);
        loginPage.setLoginOnBlock(LOGIN);
        loginPage.setPasswordOnBlock(PASSWORD);
        loginPage.pressEnter();
        Assert.assertEquals(userName, new LentaPage().getUserName());
    }

    @Test
    public void checkGoodLoggingWithButton() {
        LoginPage loginPage = new LoginPage(OK_BASE_URL);
        loginPage.setLoginOnBlock(LOGIN);
        loginPage.setPasswordOnBlock(PASSWORD);
        loginPage.pressInputButton();
        Assert.assertEquals(userName, new LentaPage().getUserName());
    }

    /*
     * Проверка авторизации с пустым полем "Логин"
     */
    @Test
    public void checkEmptyLoginWithEnter() {
        LoginPage loginPage = new LoginPage(OK_BASE_URL);
        loginPage.setPasswordOnBlock(PASSWORD);
        loginPage.pressEnter();
        Assert.assertEquals(notLoginMessege, loginPage.getError(nameOfErrorDiv));
    }

    @Test
    public void checkEmptyLoginWithButton() {
        LoginPage loginPage = new LoginPage(OK_BASE_URL);
        loginPage.setPasswordOnBlock(PASSWORD);
        loginPage.pressInputButton();
        Assert.assertEquals(notLoginMessege, loginPage.getError(nameOfErrorDiv));
    }

    /*
     * Проверка авторизации с пустым полем "Пароль"
     */
    @Test
    public void checkEmptyPasswordWithEnter() {
        LoginPage loginPage = new LoginPage(OK_BASE_URL);
        loginPage.setLoginOnBlock(LOGIN);
        loginPage.pressEnter();
        Assert.assertEquals(notPasswordMessege, loginPage.getError(nameOfErrorDiv));
    }

    @Test
    public void checkEmptyPasswordWithButton() {
        LoginPage loginPage = new LoginPage(OK_BASE_URL);
        loginPage.setLoginOnBlock(LOGIN);
        loginPage.pressInputButton();
        Assert.assertEquals(notPasswordMessege, loginPage.getError(nameOfErrorDiv));
    }

    /*
     * Проверка авторизации с пустыми полями "Пароль" и "Логин"
     */
    @Test
    public void checkEmptyPasswordAndLoginWithEnter() {
        LoginPage loginPage = new LoginPage(OK_BASE_URL);
        loginPage.pressEnter();
        Assert.assertEquals(notLoginMessege, loginPage.getError(nameOfErrorDiv));
    }

    @Test
    public void checkEmptyPasswordAndLoginWithButton() {
        LoginPage loginPage = new LoginPage(OK_BASE_URL);
        loginPage.pressInputButton();
        Assert.assertEquals(notLoginMessege, loginPage.getError(nameOfErrorDiv));
    }

}
