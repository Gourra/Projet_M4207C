import java.text.DateFormat;
import java.util.Date;

public class capteur {

    /**
     * //param args
     */
    public static void main(String[] args) {
        Date aujourdhui = new Date();

        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

        System.out.println(shortDateFormat.format(aujourdhui));
    }
}