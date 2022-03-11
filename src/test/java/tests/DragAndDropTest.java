package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactTextCaseSensitive;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @Test
    void dragAndDrop() {
        Configuration.browserSize = "1120x1088";
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Проверка открытия правильной страницы
        $(".example").shouldHave(text("Drag and Drop"));
        sleep(1000);

        // Проверка названий квадратов до их перемещения
        $("#column-a").shouldHave(exactTextCaseSensitive("A"));
        $("#column-b").shouldHave(exactTextCaseSensitive("B"));

        // Перенос элемента А на место элемента В
        $("#column-a").dragAndDropTo($("#column-b"));

        // Проверка названий квадратов после их перемещения
        $("#column-a").shouldHave(exactTextCaseSensitive("B"));
        $("#column-b").shouldHave(exactTextCaseSensitive("A"));

        sleep(1000);
    }
}
