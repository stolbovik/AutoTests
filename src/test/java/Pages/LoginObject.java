package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

/*
* Страница для входа сайта ok.ru
*/
public class LoginObject extends LoadableObject {

    /**
     * Необходимые элементы на странице
     */
    private final SelenideElement INPUT_LOGIN = $x("//*[@id='field_email']");
    private final SelenideElement INPUT_PASSWORD = $x("//*[@id='field_password']");
    private final SelenideElement INPUT_BUTTON = $x("//*[@class='login-form-actions']/input");

    public LoginObject() {
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
     */
    public LoginObject setLoginOnBlock(@NotNull String login) {
        INPUT_LOGIN.setValue(login);
        return this;
    }

    /**
     * Вводим пароль в поле Password
     */
    public LoginObject setPasswordOnBlock(@NotNull String password) {
        INPUT_PASSWORD.setValue(password);
        return this;
    }

    /**
     * Нажимаем Enter для првоерки введённых данных
     */
    public LentaObject pressEnter() {
        INPUT_PASSWORD.sendKeys(Keys.ENTER);
        return new LentaObject("//*[@class='navigation']");
    }
    /**
     * Нажимаем на кнопку "Войти в одноклассники"
     */
    public LentaObject pressInputButton() {
        INPUT_BUTTON.click();
        return new LentaObject("//*[@class='navigation']");
    }

    /**
     * Получаем текст ошибки со страницы
     */
    public String getError(@NotNull String nameOfDiv) {
        return $x(nameOfDiv).shouldBe(Condition.visible).getText();
    }
}
