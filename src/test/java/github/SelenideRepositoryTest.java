package github;
// создается в форме обратного доменного имени. Это нужно чтобы не было конфликтов.
// for ex : google.com = com.google.

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositoryTest {

    // Сначала всегда проходить тест руками. ДЕФТУЛС ВНИЗУ - косяков не будет.
    // Selenide когда открывает браузер используют чистую версию по этому  лучше исопльзовтаь режим инкогнито.
    // плагин awesome console добавляет возможность чекать скрины по линку в логе ошибки.
    // устанавливать его в Idea
    @Test
    void shouldFindSelenideAsFirstRepository() {
        // открыть страницу github.com
        Selenide.open("https://github.com");
        // ввести в поле поиска selenide и нажать Enter // если есть слэши нужно ставить кавычки - ' '
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        // нажимаем линк от первого результата поиска
        $$("ul.repo-list li").first().$("a").click();         // у элемента имя ul а класс его repo-list и любой из детей li
        //check : в заголовке встречается selenide/selenide
        $("h2").shouldHave(text("selenide/selenide"));

        // Arrange - подготовка = Given ( тож самое)
        // ACT - действие = When
        // ASSERT - проверка = There
        // find и $ синонимы

    }
}
