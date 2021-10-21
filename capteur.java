import java.util.*;
import java.text.DateFormat; 

class capteur {
    String liste [];
    ArrayList<Object> val = new ArrayList<Object>();
    public void valeur_random(){
        
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
