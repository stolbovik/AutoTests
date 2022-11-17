package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

/*
* Страница для входа сайта ok.ru
*/
public class LoginPage extends LoadablePage{

    /**
     * Необходимые элементы на странице
     */
    private final SelenideElement INPUT_LOGIN = $x("//*[@id='field_email']");
    private final SelenideElement INPUT_PASSWORD = $x("//*[@id='field_password']");
    private final SelenideElement INPUT_BUTTON = $x("//*[@class='login-form-actions']/input");

    public LoginPage() {
        checkPage();
    }

    /**
     * Проверка прогрузки
     */
    @Override
    public void checkPage() {
        INPUT_LOGIN.shouldBe(Condition.visible.because("Не отображется поле для ввода логина"));
        INPUT_PASSWORD.shouldBe(Condition.visible.because("Не отображется поле для ввода пароля"));
        INPUT_BUTTON.shouldBe(Condition.visible.because("Не отображется кнопка для входа"));
    }
    /**
     * Вводим логин в поле Login
     * @param login - наш логин
     */
    public LoginPage setLoginOnBlock(String login) {
        INPUT_LOGIN.setValue(login);
        return this;
    }

    /**
     * Вводим пароль в поле Password
     * @param password - наш пароль
     */
    public LoginPage setPasswordOnBlock(String password) {
        INPUT_PASSWORD.setValue(password);
        return this;
    }

    /**
     * Нажимаем Enter для првоерки введённых данных
     */
    public LentaPage pressEnter() {
        INPUT_PASSWORD.sendKeys(Keys.ENTER);
        return new LentaPage();
    }
    /**
     * Нажимаем на кнопку "Войти в одноклассники"
     */
    public LentaPage pressInputButton() {
        INPUT_BUTTON.click();
        return new LentaPage();
    }

    /**
     * Получаем текст ошибки со страницы
     * @param nameOfDiv - указатель на блок с текстом ошибки
     * @return -  текст ошибки
     */
    public String getError(String nameOfDiv) {
        return $x(nameOfDiv).shouldBe(Condition.visible).getText();
    }
}
