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
    private final SelenideElement nameOfUser = $x("//*[@class='tico ellip']");

    /**
     * Возвращаем полное имя пользователя
     */
    public String getUserName() {
        return nameOfUser.getText();
    }

}
