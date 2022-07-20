package allure_homework;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.*;

public class LabelsStepTest {
    @Test
    @ShowIssue
    @DisplayName("My Test")
    @Link(value = "Тестинг", url = "https://github.com")
    public void testAnnotatedTest(){
    }
    @Owner("evansidorenko")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Issues")
    @Story("Should see issue in repository")
    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ShowIssue {

    }


}
