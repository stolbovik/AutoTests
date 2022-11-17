package PopupWindows;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
/**
 * Всплывающее окно для выкладки нового поста
 */
public class LentaNewPost {
    /**
     * Необходимые элементы на окне
     */
    private final SelenideElement NEW_POST_FIELD = $x("//*[@data-module='postingForm/mediaText']");
    private final SelenideElement TO_DO_POST_BUTTON = $x("//*[@data-action='submit']");

    /**
     * Выкладываем новый пост
     */
    public void doNewPost(String post) {
        NEW_POST_FIELD.setValue(post);
        TO_DO_POST_BUTTON.shouldBe(Condition.visible).click();
    }

}
