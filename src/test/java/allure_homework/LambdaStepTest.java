package allure_homework;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.nio.charset.StandardCharsets;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;


public class LambdaStepTest {
    private static final String repository = "EvanSidorenko/allure_homework";
    private static final int number = 1;
    @BeforeAll
    static void setUp(){
        Configuration.holdBrowserOpen = true;
    }
    @Test
    public void testGitHubLambda() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + repository, () -> {
                    $(".header-search-input").click();
                    $(".header-search-input").sendKeys(repository);
                    $(".header-search-input").submit();
                });
        step("Переходим по ссылке репозитория" + repository, () -> {
            $(linkText(repository)).click();
        });
        step("Кликаем на таб Issues", () -> {
            $("a[class=\"UnderlineNav-item no-wrap js-responsive-underlinenav-item js-selected-navigation-item\"]").click();
        });
        step("Проверяем, что существует Issue c номером " + number, () -> {
            $(withText("#1")).click();
            Allure.getLifecycle().addAttachment(
                    "Исходники страницы",
                    "text/html",
                    "html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8));
        });

    }
}
