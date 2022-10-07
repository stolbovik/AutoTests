import org.junit.Assert;
import org.junit.Test;

public class LoginTests extends BaseTest{

    /**
     * Данные для работы тестов
     */
    private final static String OK_BASE_URL = "https://ok.ru/dk?st.cmd=anonymMain&st.fflo=on&st.lgn=on";
    private final String LOGIN = "stolbov_svyatoslav_02@mail.ru";
    private final String PASSWORD = "f+ac5EMrAC8gq.4";
    private final String nameOfErrorDiv = "//div[@class='input-e login_error']";
    private final String errorMessege = "Неправильно указан логин и/или пароль";
    private final String userName = "Святослав Столбов";


    /**
     * Проверка неверно введённого логина
     */
    @Test
    public void checkBadLoginLogging() {
        LoginPage loginPage = new LoginPage(OK_BASE_URL);
        loginPage.clickOnLogin(LOGIN + "error");
        loginPage.clickOnPassword(PASSWORD);
        loginPage.pressEnter();
        Assert.assertTrue(loginPage.getError(nameOfErrorDiv).equals(errorMessege));
    }

    /**
     * Проверка неверно введённого пароля
     */
    @Test
    public void checkBadPasswordLogging() {
        LoginPage loginPage = new LoginPage(OK_BASE_URL);
        loginPage.clickOnLogin(LOGIN);
        loginPage.clickOnPassword(PASSWORD + "error");
        loginPage.pressEnter();
        Assert.assertTrue(loginPage.getError(nameOfErrorDiv).equals(errorMessege));
    }

    /**
     *
     * Проверка корректно введённых данных
     */
    @Test
    public void checkGoodLogging() {
        LoginPage loginPage = new LoginPage(OK_BASE_URL);
        loginPage.clickOnLogin(LOGIN);
        loginPage.clickOnPassword(PASSWORD);
        loginPage.pressEnter();
        Assert.assertTrue(new PersonalUserPage().getUserName().equals(userName));
    }

}
