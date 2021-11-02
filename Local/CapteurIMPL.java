import java.lang.Math;
import java.util.Date;
import java.text.DateFormat; 

public class CapteurIMPL implements INTCapteur {
    //Attributs
    int id = 0;
    String unite = null;
    
    //constructeur
    CapteurIMPL(int n, String un){
        id = n;
        unite = un;
    }

    //méthodes
    public int getId() {return id;}
    
    public String getUnite() {return unite;}

    public String date(){ //genere la date d'une jolie facon
        Date date = new Date();
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        String liste = shortDateFormat.format(date);
        return liste;
    }

    public int random(){ //genere un nombre aleatoire entre 0 et 38
        int n = (int)(Math.random() * 38);
        return n;
    }

    public Data createData(){ //genere un objet data
        String date = date();
        int valeur = random();

        Data D1 = new Data(date,id,valeur,unite); 
        return D1;
    }
}
