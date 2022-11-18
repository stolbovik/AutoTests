package Pages;

import PageElements.NavigationWrapper;
import PopupWindows.LentaNewPost;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Лента одноклассников
 */
public class LentaObject extends LoadableObject {

    /**
     * Необходимые блоки на странице
     */
    private final SelenideElement DO_POST = $x("//*[@href='/post']");
    private final SelenideElement NEW_POST = $x("//*[@class='media-text_cnt']/div");
    private final SelenideElement MENU_OF_NEW_POST = $x("//*[@class='new_topic_icodown']");
    private final SelenideElement DELETE_POST_BUTTON = $x("//*[@id='hook_Block_ShortcutMenu']//span[@class='tico']");

    @NotNull
    private final NavigationWrapper navigationWrapper;

    public LentaObject(String item) {
        this.navigationWrapper = new NavigationWrapper(item);
    }

    /**
     * Проверка прогрузки страницы
     */
    @Override
    public void checkPage() {
        DO_POST.shouldBe(Condition.visible.because("Не отображается поле для новой записи"));
        navigationWrapper.checkPage();
    }

    /**
     * Возвращаем полное имя пользователя
     */
    public String getUserName() {
        return navigationWrapper.getUserName();
    }

    /**
     * Делаем новый пост
     */
    public void doNewPost(@NotNull String post) {
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
    public PersonalObject goToPersonalPage() {
        return navigationWrapper.goToPersonalPage();
    }

    /**
     * Переход страницу групп
     */
    public GroupsObject goToGroupPage() {
        return navigationWrapper.goToGroupsPage();
    }

}
