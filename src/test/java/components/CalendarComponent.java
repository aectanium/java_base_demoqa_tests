package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    private final SelenideElement yearSelect = $(".react-datepicker__year-select");
    private final SelenideElement monthSelect = $(".react-datepicker__month-select");

    public void setDate(String year, String month, String day) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public void setYear(String year) {
        yearSelect.selectOptionByValue(year);
    }

    public void setMonth(String month) {
        monthSelect.selectOptionByValue(month);
    }

    public void setDay(String day) {

        int dayNumber = Integer.parseInt(day);
        $$(".react-datepicker__day")
                .filterBy(text(String.valueOf(dayNumber)))
                .filterBy(not(cssClass("react-datepicker__day--outside-month")))
                .first()
                .click();
    }
}