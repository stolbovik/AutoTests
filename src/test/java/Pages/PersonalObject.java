package Pages;

import Resources.TestBotInfo;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;

import static com.codeborne.selenide.Selenide.$x;
/**
 * Личная страница
 */
public class PersonalObject extends LoadableObject {

    /**
     * Необходимые блоки на странице
     */
    private TestBotInfo testBotInfo;
    private final SelenideElement NAME_OF_USER = $x("//*[@class='profile-user-info_name']/h1");
    private final SelenideElement BIRTHDAY = $x("//*[@data-type='AGE']");

    public PersonalObject() {
        checkPage();
    }

    /**
     * Проверка прогрузки
     */
    @Override
    public void checkPage() {
        NAME_OF_USER.shouldBe(Condition.visible.because("Не отображается имя и фамилия пользователя"));
        BIRTHDAY.shouldBe(Condition.visible.because("Не отображается дата дня рождения"));
    }

    /**
     * Привязка тестового бота
     */
    public PersonalObject setTestBotInfo(@NotNull TestBotInfo testBotInfo) {
        this.testBotInfo = testBotInfo;
        return this;
    }

    /**
     * Геттер имени пользователя на странице
     */
    public String getNameOfUser() {
        return NAME_OF_USER.getText();
    }

    /**
     * Геттер дня рождения в читаемом для сайта виде
     */
    public String getBirthday() {
        return BIRTHDAY.getText().substring(0,BIRTHDAY.getText().indexOf('(') - 1);
    }

}
