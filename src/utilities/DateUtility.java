package utilities;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

    public static String dateToString(Date date){
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        return df.format(date);
    }

}
