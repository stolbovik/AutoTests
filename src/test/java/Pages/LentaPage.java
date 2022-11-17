package Pages;

import PopupWindows.LentaNewPost;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Лента одноклассников
 */
public class LentaPage {

    /**
     * Необходимые блоки на странице
     */
    private final SelenideElement NAME_OF_USER = $x("//*[@class='tico ellip']");
    private final SelenideElement DO_POST = $x("//*[@href='/post']");
    private final SelenideElement NEW_POST = $x("//*[@class='media-text_cnt']/div");
    private final SelenideElement MENU_OF_NEW_POST = $x("//*[@class='new_topic_icodown']");
    private final SelenideElement DELETE_POST_BUTTON = $x("//*[@id='hook_Block_ShortcutMenu']//span[@class='tico']");

    /**
     * Возвращаем полное имя пользователя
     */
    public String getUserName() {
        return NAME_OF_USER.shouldBe(Condition.visible).getText();
    }
    /**
     * Делаем новый пост
     */
    public void doNewPost(String post) {
        DO_POST.shouldBe(Condition.visible).click();
        new LentaNewPost().doNewPost(post);
    }

    /**
     * Удаляем новый пост новый пост
     */
    public void deleteNewPost() {
        MENU_OF_NEW_POST.shouldBe(Condition.visible).click();
        DELETE_POST_BUTTON.shouldBe(Condition.visible).click();
    }

    /**
     * Берём текст нового поста
     */
    public String getNewPostsText() {
        return NEW_POST.shouldBe(Condition.visible).getText();
    }

}
