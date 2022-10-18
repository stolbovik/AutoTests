package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Лента одноклассников
 */
public class LentaPage {

    /**
     * Блок на странцие с полным именем пользователя
     */
    private final SelenideElement nameOfUser = $x("//a[@data-l='t,userPage']");

    /**
     * Возвращаем полное имя пользователя
     */
    public String getUserName() {
        return nameOfUser.getText();
    }

}
