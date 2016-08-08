package np.com.rts.JsonRequestHandler.helpers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTime {
    static DateFormat dateFormat;
    static Date date;

    public static boolean checkDateFormat(String input) {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        try {
            format.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public String standardizeTime(String time, String AMPM) {
        if (AMPM.equalsIgnoreCase("hours")) {
            time = time + ":00:00";
        }
        if(AMPM.equals("PM")){
            try {
                Date given = new SimpleDateFormat("hha").parse(time+ AMPM);
                time = new SimpleDateFormat("HH:mm:ss").format(given);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return time;
    }

    public String getCurrentTime() {
        dateFormat = new SimpleDateFormat("kk-mm-ss");
        date = new Date();
        return dateFormat.format(date);
    }

    public int getCurrentHour() {
        dateFormat = new SimpleDateFormat("kk");
        date = new Date();
        return Integer.valueOf(dateFormat.format(date));
    }

    public String getDate() {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date = new Date();
        return dateFormat.format(date);
    }
}
