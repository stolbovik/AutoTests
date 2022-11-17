package Resources;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
public class TestBotInfo {

    private final String login;
    private final String password;
    private Date birthday;
    private String firstName;
    private String lastName;
    private int countOfPost;
    private int numOfSubscribers;
    private String id;


    public TestBotInfo(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public TestBotInfo(String login, String password, String firstName, String lastName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public TestBotInfo(String login, String password, Date birthday,
                       String firstName, String lastName, int countOfPost, int numOfSubscribers, String id) {
        this.login = login;
        this.password = password;
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
