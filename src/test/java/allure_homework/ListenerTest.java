package allure_homework;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class ListenerTest {
    @Test
    public void testGitHub() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("EvanSidorenko/allure_homework");
        $(".header-search-input").submit();

        $(linkText("EvanSidorenko/allure_homework")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#1"));
    }
}
