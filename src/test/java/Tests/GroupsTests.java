package Tests;

import Pages.GroupsObject;
import Pages.LoginObject;
import Resources.Tags;
import Resources.TestBotInfo;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

/*
 * Тесты для страницы групп
 */
@Tag(Tags.TAG_GROUPS_TESTS)
@DisplayName("Groups Tests")
public class GroupsTests extends BaseTest{

    /**
     * Данные для работы тестов
     */
    private final TestBotInfo TEST_BOT_INFO = new TestBotInfo("technoPol4", "technoPolis2022",
            "technoPol4", "technoPol4");

    private final String JOIN_MESSAGE = "Вы в группе";

    /*
     * Пооверяем корректность вступления в новую группу
     * */
    @Test
    @Tag(Tags.TAG_JOIN_GROUP)
    @DisplayName("Check good join to new group")
    public void joinToNewGroup() {
        GroupsObject groupsPage = new LoginObject()
                .setLoginOnBlock(TEST_BOT_INFO.getLOGIN())
                .setPasswordOnBlock(TEST_BOT_INFO.getPASSWORD())
                .pressEnter()
                .goToGroupPage();
        String result = groupsPage.joinToGroup(1);
        Assertions.assertEquals(JOIN_MESSAGE, result, "Не удалось вступить в группу");
    }

}
