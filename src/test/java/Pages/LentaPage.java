package Pages;

import PopupWindows.LentaNewPost;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Лента одноклассников
 */
public class LentaPage extends LoadablePage{

    /**
     * Необходимые блоки на странице
     */
    private final SelenideElement NAME_OF_USER = $x("//*[@class='tico ellip']");
    private final SelenideElement DO_POST = $x("//*[@href='/post']");
    private final SelenideElement NEW_POST = $x("//*[@class='media-text_cnt']/div");
    private final SelenideElement MENU_OF_NEW_POST = $x("//*[@class='new_topic_icodown']");
    private final SelenideElement DELETE_POST_BUTTON = $x("//*[@id='hook_Block_ShortcutMenu']//span[@class='tico']");

    /**
     * Проверка прогрузки
     */
    @Override
    public void checkPage() {
        NAME_OF_USER.shouldBe(Condition.visible.because("Не отображается поле с именем и фамилией пользователя"));
        DO_POST.shouldBe(Condition.visible.because("Не отображается поле для новой записи"));
    }
    /**
     * Возвращаем полное имя пользователя
     */
    public String getUserName() {
        return NAME_OF_USER.getText();
    }
    /**
     * Делаем новый пост
     */
    public void doNewPost(String post) {
        DO_POST.click();
        new LentaNewPost().doNewPost(post);
    }

    /**
     * Удаляем новый пост
     */
    public void deleteNewPost() {
        MENU_OF_NEW_POST.shouldBe(Condition.visible.because("Не отображается меню нового поста")).click();
        DELETE_POST_BUTTON.shouldBe(Condition.visible.because("Не отображается кнопка удаления поста")).click();
    }

    /**
     * Берём текст нового поста
     */
    public String getNewPostsText() {
        return NEW_POST.shouldBe(Condition.visible.because("Не отображается новый пост")).getText();
    }

    /**
     * Переход на личную странциу
     */
    public PersonalPage goToPersonaPage() {
        NAME_OF_USER.click();
        return new PersonalPage();
    }
}
