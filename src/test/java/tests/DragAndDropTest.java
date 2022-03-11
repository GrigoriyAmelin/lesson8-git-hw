package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @Test
    void dragAndDrop() {
        Configuration.browserSize = "1120x1088";
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Проверка открытия правильной страницы
        $(".example").shouldHave(text("Drag and Drop"));

        // Перенос элемента А на место элемента В
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(300,0)
                .release().perform();

//        actions().dragAndDropBy($("#column-a"), 200, 0).perform();

        sleep(3000);

    }
}
