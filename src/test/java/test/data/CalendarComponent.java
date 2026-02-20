package test.data;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private final SelenideElement yearSelect = $(".react-datepicker__year-select");
    private final SelenideElement monthSelect = $(".react-datepicker__month-select");

    public void setDate(String year, String month, String day) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public void setYear(String year) {
        yearSelect.click();
        $("option[value='" + year + "']").click();
    }

    public void setMonth(String month) {
        monthSelect.click();
        $("option[value='" + month + "']").click();
    }

    public void setDay(String day) {
        $(".react-datepicker__day.react-datepicker__day--" + day).click();
    }

    public void setDate(int year, int month, int day) {
        String monthValue = String.valueOf(month - 1);
        String dayValue = String.format("%03d", day);
        setDate(String.valueOf(year), monthValue, dayValue);
    }
}