import static com.codeborne.selenide.Condition.*;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Story("Использование Lambda steps")
@Owner("Dmitriy")
@Tag("alfaTest")
public class TestsAlfaBank extends BaseClass{

    @Tag("clickTest")
    @Test
    void openPrivatePerson() {
        step("Open \"Частным лицам\"", () -> {
            $(".h1Cda9K").$(byText("Частным лицам")).click();
            $(".a2I4Oki.h1NqZY9").shouldHave(text("ДЕНЬГИ НА ЛЮБЫЕ ЦЕЛИ"));
        });
    }

    @Tag("clickTest")
    @Test
    void openIp() {
        step("Open \"Малому бизнесу и ИП\"", () -> {
            $(".h1Cda9K").$(withText("Малому бизнесу")).click();
            $("#Hide").shouldHave(text("Управляйте бизнесом"));
        });
    }

    @Tag("clickTest")
    @Test
    void openCorp() {
        step("Open \"Корпорациям\"", () -> {
            $(".h1Cda9K").$(withText("Корпорациям")).click();
            $(".sme-form", 0).shouldBe(visible);
        });
    }

    @Tag("searchTest")
    @Test
    void searchOnSite() {
        step("Open Search", () -> {
            $(".a3qH-MS").click();
            $(by("type", "search")).shouldBe(visible);
            $(by("type", "search")).setValue("Вклад").pressEnter();
            $("#ya-site-results").shouldHave(text("Вклады"));
        });
    }
}