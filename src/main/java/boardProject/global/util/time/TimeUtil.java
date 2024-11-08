package boardProject.global.util.time;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.SimpleFormatter;

@Component
@NoArgsConstructor
public class TimeUtil {


  public static String getNowAsUtcZero() {

      ZonedDateTime utcTime = Instant.now().atZone(ZoneOffset.UTC);

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

      return utcTime.format(formatter) + " (UTC+0)";

    }

    public static boolean isTodayMonthDayAfter (String birthday) {

        if (LocalDate.now().getMonth().getValue() > Integer.valueOf(birthday.substring(4, 6))) {
            return true;
        } else if (LocalDate.now().getDayOfMonth() >= Integer.valueOf(birthday.substring(6))) {
            return true;
        } else {
            return false;
        }
    }


}
