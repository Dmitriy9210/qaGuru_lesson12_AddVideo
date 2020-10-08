import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static helpers.AttachmentsHelper.*;
import static helpers.DriverHelper.configureSelenide;
import static helpers.DriverHelper.getConsoleLogs;
import static io.qameta.allure.Allure.step;

public class BaseClass {
    @BeforeEach
    void setUp() {
        configureSelenide();
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));

        step("Open Site AlfaBank", () -> {
            open("https://alfabank.ru/");
        });
    }

    @AfterEach
    void closeAll() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        closeWebDriver();
    }
}
