import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.text.DateFormat; 

class Capteur {
    //Attributs
    int id;
    String unite;

    //Constructeur
    public Capteur(int n, String e_unite){
        id = n; //Initiation du n° id
        unite = e_unite;
    }

    //Méthodes d'acces
    public int getId() {return id;}
    public String getUnite() {return unite;}
    public void setUnite(String e_unite) {unite = e_unite;}

    //###################################
    //          METHODES
    //###################################

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
