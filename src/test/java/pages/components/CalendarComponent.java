package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

//    String dayCss = "";

    public void setDate(String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--002").click();
    }
}
