package Pages;

import PageElements.ListOfPopularGroups;
import PageElements.NavigationWrapper;
import org.jetbrains.annotations.NotNull;

/*
 * Страницы Группы
 * */
public class GroupsObject extends LoadableObject {

    /*
     * Необходимые элементы на странице
     * */
    @NotNull
    private final NavigationWrapper NAVIGATION_WRAPPER;

    @NotNull
    private final ListOfPopularGroups LIST_OF_POPULAR_GROUP;

    public GroupsObject(@NotNull String item1,
                        @NotNull String item2) {
        this.NAVIGATION_WRAPPER = new NavigationWrapper(item1);
        this.LIST_OF_POPULAR_GROUP = new ListOfPopularGroups(item2);
    }
    /*
     * Проверка прогрузки страницы
     * */
    @Override
    public void checkPage(){
        NAVIGATION_WRAPPER.checkPage();
        LIST_OF_POPULAR_GROUP.checkPage();
    }
    /*
     * Вступить в группу в спике популярных групп
     * */
    public String joinToGroup(int i) {
        return LIST_OF_POPULAR_GROUP.joinToGroup(LIST_OF_POPULAR_GROUP.getGroup(i));
    }
}
