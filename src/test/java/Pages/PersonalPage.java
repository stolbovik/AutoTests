package Pages;

import Resources.TestBotInfo;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.Calendar;

import static com.codeborne.selenide.Selenide.$x;
/**
 * Личная страница
 */
public class PersonalPage extends LoadablePage{

    /**
     * Необходимые блоки на странице
     */
    private TestBotInfo testBotInfo;
    private final SelenideElement NAME_OF_USER = $x("//*[@class='profile-user-info_name']/h1");
    private final SelenideElement COUNT_OF_POSTS = $x("//*[@href='/profile/585556286938/statuses']//span");
    private final SelenideElement BIRTHDAY = $x("//*[@data-type='AGE']");
    private final SelenideElement COUNT_OF_SUBSCRIBERS = $x("//*[@data-type='SUBSCRIBERS']/a");

    public PersonalPage() {
        checkPage();
    }

    /**
     * Проверка прогрузки
     */
    @Override
    public void checkPage() {
        NAME_OF_USER.shouldBe(Condition.visible.because("Не отображается имя и фамилия пользователя"));
        COUNT_OF_POSTS.shouldBe(Condition.visible.because("Не отображается количество заметок"));
        BIRTHDAY.shouldBe(Condition.visible.because("Не отображается дата дня рождения"));
        COUNT_OF_SUBSCRIBERS.shouldBe(Condition.visible.because("Не отображается количество подписчиков"));
    }

    /**
     * Привязка тестового бота
     */
    public PersonalPage setTestBotInfo(TestBotInfo testBotInfo) {
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
     * Геттер количества подписчиков
     */
    public char getCountOfSubscribers() {
        return COUNT_OF_SUBSCRIBERS.getText().charAt(0);
    }

    /**
     * Геттер количества записей
     */
    public String getCountOfPost() {
        return COUNT_OF_POSTS.getText();
    }

    /**
     * Геттер дня рождения в читаемом для сайта виде
     */
    public String getBirthday() {
        return BIRTHDAY.getText().substring(0,BIRTHDAY.getText().indexOf('(') - 1);
    }

}
