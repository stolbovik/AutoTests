package PageElements;

import Pages.GroupsObject;
import Pages.LoadableObject;
import Pages.PersonalObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Элемент навигации на странице
 */
public class NavigationWrapper extends LoadableObject {
    /**
     * Все необходимые элементы в блоке
     */
    @NotNull
    private final SelenideElement ITEM;
    private final String NAME_OF_USER = ".//*[@data-l='t,userPage']";
    private final String LENTA = ".//*[@data-l='t,userMain']";
    private final String FRIENDS = ".//*[@data-l='t,userFriend']";
    private final String PHOTOS = ".//*[@data-l='t,userPhotos']";
    private final String GROUPS = ".//*[@data-l='t,userAltGroup']";
    private final String GAMES = ".//*[@data-l='t,appsShowcaseHD']";
    private final String GIFTS = ".//*[@data-l='t,giftsFront']";
    private final String RECOMENDATIONS = ".//*[@data-l='t,discovery']";
    private final String MORE = ".//*[@data-l='t,toggler']";

    public NavigationWrapper(@NotNull String ITEM) {
        this.ITEM = $x(ITEM);
    }

    /**
     * Проверка загрузки страницы
     */
    @Override
    public void checkPage(){
        ITEM.shouldBe(Condition.visible.because("Не отображается окно навигации"));
        ITEM.$x(NAME_OF_USER).shouldBe(Condition.visible.because("В навигации не отображается имя пользователя"));
        ITEM.$x(LENTA).shouldBe(Condition.visible.because("В навигации не отображается переход на ленту"));
        ITEM.$x(FRIENDS).shouldBe(Condition.visible.because("В навигации не отображается переход на друзей"));
        ITEM.$x(PHOTOS).shouldBe(Condition.visible.because("В навигации не отображается переход на фото"));
        ITEM.$x(GROUPS).shouldBe(Condition.visible.because("В навигации не отображается переход на группы"));
        ITEM.$x(GAMES).shouldBe(Condition.visible.because("В навигации не отображается переход на игры"));
        ITEM.$x(GIFTS).shouldBe(Condition.visible.because("В навигации не отображается переход на подарки"));
        ITEM.$x(RECOMENDATIONS).shouldBe(Condition.visible.because("В навигации не отображается переход на рекомендации"));
        ITEM.$x(MORE).shouldBe(Condition.visible.because("В навигации не отображается переход в раздец рекомендации"));
    }

    public String getUserName() {
        return ITEM.$x(NAME_OF_USER).getText();
    }

    /**
     * Переход по элементам (реализованы только необходимые для тестов)
     */
    public PersonalObject goToPersonalPage() {
        ITEM.$x(NAME_OF_USER).click();
        return new PersonalObject();
    }

    public GroupsObject goToGroupsPage() {
        ITEM.$x(GROUPS).click();
        return new GroupsObject("//*[@class='navigation']", "//*[@data-block='PopularGroupsListBlock']");
    }

}
