package PageElements;

import Pages.LoadableObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;

import static com.codeborne.selenide.Selenide.$x;

/*
* Список популярных групп на странице "Группы"
* */
public class ListOfPopularGroups extends LoadableObject {
    /*
     * Необходимые элементы в блоке
     * */
    @NotNull
    private final SelenideElement ITEM;
    private final String GROUP_ELEMENT = ".//*[@data-l='groupCard,POPULAR_GROUPS.popularTop']";
    private final String JOIN_BUTTON = ".//*[@data-l='t,join']";
    private final String JOIN_GOOD_MESSAGE = ".//groups-join-result";

    public ListOfPopularGroups(@NotNull String ITEM) {
        this.ITEM = $x(ITEM);
    }

    /*
     * Проверка прогурзки страницы
     * */
    @Override
    public void checkPage(){
        ITEM.shouldBe(Condition.visible.because("Не отображается список популярных групп"));
    }

    /*
     * Возвратить элемент необходимой группы
     * */
    public SelenideElement getGroup(int i) {
        return ITEM.$x(GROUP_ELEMENT+"["+i+"]").shouldBe(Condition.visible.
                because("Группа под номером " + i + " не отображается"));
    }

    /*
     * Вступить в переданную группу
     * */
    public String joinToGroup(@NotNull SelenideElement group) {
         group.$x(JOIN_BUTTON)
                 .shouldBe(Condition.visible
                        .because("На карточке группы не отображается кнопка встпуления"))
                 .click();
         return group.$x(JOIN_GOOD_MESSAGE).shouldBe(Condition.visible.because("Не удалось вступить в группу")).getText();
    }

}
