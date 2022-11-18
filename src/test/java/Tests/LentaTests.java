package Tests;
import Pages.LentaObject;
import Pages.LoginObject;
import Resources.Tags;
import Resources.TestBotInfo;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Тесты для страници ленты
 */
@Tag(Tags.TAG_LENTA_TESTS)
@DisplayName("Tests for Lenta")
public class LentaTests extends BaseTest{
    /**
     * Необходимые блоки на странице
     */
    private final TestBotInfo TEST_BOT_INFO = new TestBotInfo("technoPol4", "technoPolis2022");

    /**
     * Проверка выкладки новых постов с разным содержанием
     */
    @Tag(Tags.TAG_ADD_POST)
    @DisplayName("New several post ")
    @ParameterizedTest(name = "New post {index} with {0} ")
    @ValueSource(strings = {"Name", "341", "N134Mfd3"})
    public void doSeveralPosts(@NotNull String post) {
        LentaObject lentaPage = new LoginObject().setLoginOnBlock(TEST_BOT_INFO.getLOGIN())
                .setPasswordOnBlock(TEST_BOT_INFO.getPASSWORD()).pressEnter();
        lentaPage.checkPage();
        lentaPage.doNewPost(post);
        Assertions.assertEquals(post, lentaPage.getNewPostsText(), "Error with post new text");
        lentaPage.deleteNewPost();
    }

}
