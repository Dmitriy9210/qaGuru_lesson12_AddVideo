package tests;

import static com.codeborne.selenide.Condition.*;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Owner("Dmitriy")
@Tag("alfaTest")
@Story("Использование Lambda steps")
public class TestsAlfaBank extends TestBase {

    @Test
    @Tag("clickTest")
    void openPrivatePerson() {
        step("Open Site AlfaBank", () -> {
            open("https://alfabank.ru/");
        });

        step("Open \"Частным лицам\"", () -> {
            $(".h1Cda9K").$(byText("Частным лицам")).click();
            $(".a2I4Oki.h1NqZY9").shouldHave(text("ДЕНЬГИ НА ЛЮБЫЕ ЦЕЛИ"));
        });
    }

    @Test
    @Tag("clickTest")
    void openIp() {
        step("Open Site AlfaBank", () -> {
            open("https://alfabank.ru/");
        });

        step("Open \"Малому бизнесу и ИП\"", () -> {
            $(".h1Cda9K").$(withText("Малому бизнесу")).click();
            $("#Hide").shouldHave(text("Управляйте бизнесом"));
        });
    }

    @Test
    @Tag("clickTest")
    void openCorp() {
        step("Open Site AlfaBank", () -> {
            open("https://alfabank.ru/");
        });

        step("Open \"Корпорациям\"", () -> {
            $(".h1Cda9K").$(withText("Корпорациям")).click();
            $(".sme-form", 0).shouldBe(visible);
        });
    }

    @Test
    @Tag("searchTest")
    void searchOnSite() {
        step("Open Site AlfaBank", () -> {
            open("https://alfabank.ru/");
        });

        step("Open Search", () -> {
            $(".a3qH-MS").click();
            $(by("type", "search")).shouldBe(visible);
            $(by("type", "search")).setValue("Вклад").pressEnter();
            $("#ya-site-results").shouldHave(text("Вклады"));
        });
    }
}