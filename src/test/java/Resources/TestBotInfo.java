package Resources;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
import java.util.Date;

/*
* Класс пользователя
* */
@Getter
@Setter
public class TestBotInfo {
    /*
     * Инфомрация о пользователе (только нужная в тестах)
     * */
    @NotNull
    private final String LOGIN;

    @NotNull
    private final String PASSWORD;

    @NotNull
    private Date birthday;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private int countOfPost;

    private int numOfSubscribers;

    @NotNull
    private String id;


    public TestBotInfo(@NotNull String LOGIN,
                       @NotNull String PASSWORD) {
        this.LOGIN = LOGIN;
        this.PASSWORD = PASSWORD;
    }

    public TestBotInfo(@NotNull String LOGIN,
                       @NotNull String PASSWORD,
                       @NotNull String firstName,
                       @NotNull String lastName) {
        this.LOGIN = LOGIN;
        this.PASSWORD = PASSWORD;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public TestBotInfo(@NotNull String LOGIN,
                       @NotNull String PASSWORD,
                       @NotNull Date birthday,
                       @NotNull String firstName,
                       @NotNull String lastName,
                       int countOfPost,
                       int numOfSubscribers,
                       @NotNull String id) {
        this.LOGIN = LOGIN;
        this.PASSWORD = PASSWORD;
        this.birthday = birthday;
        this.firstName = firstName;
        this.lastName = lastName;
        this.countOfPost = countOfPost;
        this.numOfSubscribers = numOfSubscribers;
        this.id = id;
    }

    /**
     * Геттер дня рождения в читаемом для сайта виде
     */
    public String getBirthday() {
        String month = " ";
        switch (birthday.getMonth()) {
            case(Calendar.JANUARY) -> month = " января";
            case(Calendar.FEBRUARY) -> month = " февраля";
            case(Calendar.MARCH) -> month = " марта";
            case(Calendar.APRIL) -> month = " апреля";
            case(Calendar.MAY) -> month = " мая";
            case(Calendar.JUNE) -> month = " июня";
            case(Calendar.JULY) -> month = " июля";
            case(Calendar.AUGUST) -> month = " августа";
            case(Calendar.SEPTEMBER) -> month = " сентября";
            case(Calendar.OCTOBER) -> month = " октября";
            case(Calendar.NOVEMBER) -> month = " ноября";
            case(Calendar.DECEMBER) -> month = " декабря";
        }
        return birthday.getDate() + month + ' ' + birthday.getYear();
    }
}
