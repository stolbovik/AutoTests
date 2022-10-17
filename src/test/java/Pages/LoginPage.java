package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

/*
* Страница для входа сайта ok.ru
*/
public class LoginPage {

    /**
     * Поля Input под логин и пароль
     */
    private final SelenideElement inputLogin = $x("//input[@name=\"st.email\"]");
    private final SelenideElement inputPassword = $x("//input[@name=\"st.password\"]");

    public LoginPage(String url) {
        Selenide.open(url);
    }

    /**
     * Вводим логин в поле Login
     * @param login - наш логин
     */
    public void clickOnLogin(String login) {
        inputLogin.setValue(login);
    }

    /**
     * Вводим пароль в поле Password
     * @param password - наш пароль
     */
    public void clickOnPassword(String password) {
        inputPassword.setValue(password);
    }

    /**
     * Нажимаем Enter для првоерки введённых данных
     */
    public void pressEnter() {
        inputPassword.sendKeys(Keys.ENTER);
    }

    /**
     * Получаем текст ошибки со страницы
     * @param nameOfDiv - указатель на блок с текстом ошибки
     * @return -  текст ошибки
     */
    public String getError(String nameOfDiv) {
        return $x(nameOfDiv).getText();
    }
}