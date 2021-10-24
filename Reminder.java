import java.util.*;
import java.text.DateFormat; 
import java.util.Timer;
import java.util.TimerTask;


public class Reminder {
    Timer timer;
    mesure cap = new mesure();

    public Reminder(int seconds) {
        timer = new Timer(); // Utilise la class Timer pour creer un minuteur
        timer.schedule(new RemindTask(), seconds*1000*60); // convertit pour avoir de secondes (*1000) et avec le *60 en minutes
	}

    class RemindTask extends TimerTask {
        public void run() {
            cap.chiant(); // Effectue le programme
            System.out.println("Time's up!");
            timer.cancel(); //Coupe le timer précédent
            new Reminder(10);// Définie 10 secondes de timer
        }
    }

    public static void main(String args[]) {
        new Reminder(1);   // Définie le nombres de secondes de timer
        System.out.println("Task scheduled.");
    }
}


class mesure {
    String liste [];
    ArrayList<Object> val = new ArrayList<Object>();
    public void chiant(){
        
        Date aujourdhui = new Date();
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        int n;
        String v = "";
        n = (int)(Math.random() * 50);
        v = v + n;

        String liste = String.format("%-20s %-20s %-5s %-20s", shortDateFormat.format(aujourdhui), "Capteur n°1", v, "Degré(s)");
        val.add(liste);
        //for (int i = 0; i < val.size(); i++) {
        for (Object str:val){
                
            System.out.println(str); // Cette ligne permet d'afficher la Arraylist sans les crochets.
        }
        //}
    }
}