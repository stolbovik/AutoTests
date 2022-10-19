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
     * Необхожимые элементы на странице
     */
    private final SelenideElement inputLogin = $x("//*[@id='field_email']");
    private final SelenideElement inputPassword = $x("//*[@id='field_password']");
    private final SelenideElement inputButton = $x("//*[@class='login-form-actions']/input");

    public LoginPage(String url) {
        Selenide.open(url);
    }

    /**
     * Вводим логин в поле Login
     * @param login - наш логин
     */
    public void setLoginOnBlock(String login) {
        inputLogin.setValue(login);
    }

    /**
     * Вводим пароль в поле Password
     * @param password - наш пароль
     */
    public void setPasswordOnBlock(String password) {
        inputPassword.setValue(password);
    }

    /**
     * Нажимаем Enter для првоерки введённых данных
     */
    public void pressEnter() {
        inputPassword.sendKeys(Keys.ENTER);
    }
    /**
     * Нажимаем на кнопку "Войти в одноклассники"
     */
    public void pressInputButton() {
        inputButton.click();
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
