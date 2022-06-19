package selenide;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWikiHw {

    /*
     Q: 1. Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что,
  поиск найдёт разные элементы? Если может - приведите пример, когда.
     A: Разница есть. В случае с $("h1 div"); будет выбран первый по списку/попавшийся
     элемент,который подойдет под условие, что div сиблинги и родитель h1.
     $("h1").$("div") При селекторе такого вида будет выбран родительский элемент h1
     но в нём может и не быть сиблингов div.
 */

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    @DisplayName("GitHubSoftAssertionTest")
    void gitHubSoftAssertionTest() {

       // - Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        // - Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

       // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("ul li.wiki-more-pages-link").$("button").click();
        $("ul[data-filterable-for=wiki-pages-filter]");

        // - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(byText("SoftAssertions")).click();
        $$(".markdown-body h4").findBy(text("JUnit5"))
                .shouldHave(text("Using JUnit5 extend test class:"));
    }


}
