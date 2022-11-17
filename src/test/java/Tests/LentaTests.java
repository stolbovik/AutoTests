package Tests;
import Pages.LentaPage;
import Pages.LoginPage;
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
    private final String LOGIN = "technoPol4";
    private final String PASSWORD = "technoPolis2022";
    private final String TAG_TEST_POST = "PostTest";

    /**
     * Проверка выкладки новых постов с разным содержанием
     */
    @Tag(TAG_TEST_POST)
    @DisplayName("New several post ")
    @ParameterizedTest(name = "New post {index} with {0} ")
    @ValueSource(strings = {"Name", "341", "N134Mfd3"})
    public void doSeveralPosts(String post) {
        LentaPage lentaPage = new LoginPage().setLoginOnBlock(LOGIN)
                .setPasswordOnBlock(PASSWORD).pressEnter();
        lentaPage.doNewPost(post);
        Assertions.assertEquals(post, lentaPage.getNewPostsText(), "Error with post new text");
        lentaPage.deleteNewPost();
    }

}
