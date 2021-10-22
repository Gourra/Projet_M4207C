import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.text.DateFormat; 

class Capteur {
    //Attributs
    int id;
    String unite;
    int initialDataInt;

    //Constructeur
    public Capteur(int n, String e_unite){
        id = n; //Initiation du n° id
        unite = e_unite;
        initialDataInt = 0;
    }

    //Méthodes d'acces
    public int getId() {return id;}

    //###################################
    //          METHODES
    //###################################

    public String date(){
        Date date = new Date();
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        String liste = shortDateFormat.format(date);
        return liste;
    }

    public int random(){
        int n = (int)(Math.random() * 50);
        return n;
    }

    public Data createData(){
        String date = date();
        int valeur = random();

        Data D1 = new Data(date,id,valeur,unite); 
        return D1;
    }
}
