package Tests;

import Pages.LoginObject;
import Pages.PersonalObject;
import Resources.Tags;
import Resources.TestBotInfo;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import java.util.Calendar;
import java.util.Date;

/*
 * Тесты для личной страницы
 */
@Tag(Tags.TAG_PERSONAL_PAGE_TEST)
@DisplayName("Personal Page Tests")
public class PersonalPageTests extends BaseTest{

    /**
     * Данные для работы тестов
     */
    private final TestBotInfo TEST_BOT_INFO = new TestBotInfo("technoPol4", "technoPolis2022",
            new Date(1986, Calendar.APRIL, 20), "technoPol4",
            "technoPol4", 1, 1, "585556286938");

    @Test
    @Tag(Tags.TAG_PERSONAL_INFO)
    @DisplayName("Check info about user on Personal page")
    public void checkInfoAboutUser() {
        PersonalObject personalPage = new LoginObject().setLoginOnBlock(TEST_BOT_INFO.getLOGIN())
                .setPasswordOnBlock(TEST_BOT_INFO.getPASSWORD()).pressEnter()
                .goToPersonalPage().setTestBotInfo(TEST_BOT_INFO);
        Assertions.assertAll(
                () -> Assertions.assertEquals(TEST_BOT_INFO.getFirstName() + ' ' + TEST_BOT_INFO.getLastName(),
                        personalPage.getNameOfUser(), "Не совпадают имена"),
                () -> Assertions.assertEquals(TEST_BOT_INFO.getBirthday(), personalPage.getBirthday(),
                        "Не совпадает дни рождения")
        );
    }

}
