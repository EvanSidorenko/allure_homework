package allure_homework;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
public class AnnotationStepTest {
    private static final String repository = "EvanSidorenko/allure_homework";
    private static final int number = 1;

    @Test
    public void testGitHubLambda() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebTest webTest = new WebTest();
        webTest.openMainPage();
        webTest.searchForRepository(repository);
        webTest.clickOnRepositoryLink(repository);
        webTest.openIssuesTab();
        webTest.shoudSeeIssueWithNumber(number);
    }
}
