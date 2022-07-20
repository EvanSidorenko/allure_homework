package allure_homework;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebTest {
    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com");
    }
    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }
    @Step("Переходим по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo){
        $(linkText(repo)).click();
    }
    @Step("Кликаем на таб Issues")
    public void openIssuesTab(){
        $("a[class=\"UnderlineNav-item no-wrap js-responsive-underlinenav-item js-selected-navigation-item\"]").click();
    }
    @Step ("Проверяем, что существует Issue c номером {number}")
    public void shoudSeeIssueWithNumber(int number){
        $(withText("#" + number)).should(Condition.visible);
        attachScreenshot();

    }
    @Attachment(value = "Мой скриншот", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot(){
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
