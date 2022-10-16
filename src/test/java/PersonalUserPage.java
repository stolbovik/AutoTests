import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Главная личная страница пользователя
 */
public class PersonalUserPage {

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
