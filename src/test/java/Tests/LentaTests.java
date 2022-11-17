package Tests;
import Pages.LentaPage;
import Pages.LoginPage;
import Resources.Tags;
import Resources.TestBotInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Тесты для страници ленты
 */
@Tag("LentaTests")
@DisplayName("Tests for Lenta")
public class LentaTests extends BaseTest{
    /**
     * Необходимые блоки на странице
     */
    private final TestBotInfo testBotInfo = new TestBotInfo("technoPol4", "technoPolis2022");

    /**
     * Проверка выкладки новых постов с разным содержанием
     */
    @Tag(Tags.TAG_TEST_POST)
    @DisplayName("New several post ")
    @ParameterizedTest(name = "New post {index} with {0} ")
    @ValueSource(strings = {"Name", "341", "N134Mfd3"})
    public void doSeveralPosts(String post) {
        LentaPage lentaPage = new LoginPage().setLoginOnBlock(testBotInfo.getLogin())
                .setPasswordOnBlock(testBotInfo.getPassword()).pressEnter();
        lentaPage.checkPage();
        lentaPage.doNewPost(post);
        Assertions.assertEquals(post, lentaPage.getNewPostsText(), "Error with post new text");
        lentaPage.deleteNewPost();
    }

}
