package Tests;

import Pages.LoginPage;
import Pages.PersonalPage;
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
@Tag("PersonalPageTests")
@DisplayName("Personal Page Tests")
public class PersonalPageTests extends BaseTest{

    /**
     * Данные для работы тестов
     */
    private final TestBotInfo testBotInfo = new TestBotInfo("technoPol4", "technoPolis2022",
            new Date(1986, Calendar.APRIL, 20), "technoPol4",
            "technoPol4", 1, 1, "585556286938");

    @Test
    @DisplayName("Check info about user on Personal page")
    public void checkInfoAboutUser() {
        PersonalPage personalPage = new LoginPage().setLoginOnBlock(testBotInfo.getLogin())
                .setPasswordOnBlock(testBotInfo.getPassword()).pressEnter()
                .goToPersonaPage().setTestBotInfo(testBotInfo);
        Assertions.assertAll(
                () -> Assertions.assertEquals(testBotInfo.getFirstName() + ' ' + testBotInfo.getLastName(),
                        personalPage.getNameOfUser(), "Не совпадают имена"),
                () -> Assertions.assertEquals(Integer.toString(testBotInfo.getCountOfPost()),
                        personalPage.getCountOfPost(), "Не совпадает количество постов"),
                () -> Assertions.assertEquals(Integer.toString(testBotInfo.getNumOfSubscribers()),
                        Character.toString(personalPage.getCountOfSubscribers()), "Не совпадает количество подписчиков"),
                () -> Assertions.assertEquals(testBotInfo.getBirthday(), personalPage.getBirthday(),
                        "Не совпадает дни рождения")
        );
    }

}
