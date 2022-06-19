package github;

// Никогда не доверяй тесту который ты не видел упавшим.
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ContributorsTest {

    // Селиниум считает видимым любой элемент экрана до которого можно доскролить стандартными элементами браузера.
    // даже если окно будет очень узкий он найдет нужный элемент.
    // дефтулс --F8 ( resource) если не поймать поп ап. Заморозить через F8( дебагер)
    // Вызывать через консоль в дефтулсе - debugger - setTimeout(function () {debugger}, 3000);
    // Никогда не доверяй тесту который ты не видел упавшим.
    @Test
    void solntsevShouldBeFirstContributors() {
        // Open repository page
        open("https://github.com/selenide/selenide");

        // bring mouse over the first avatar on contributor
        $(".Layout-sidebar").$(Selectors.byText("Contributors")).ancestor("div")
                .$$("ul li").first().hover();

        $$(".Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));

    }

}
