import java.util.*;
import java.text.DateFormat; 

class capteur { //Classe Capteur
    String liste []; //Tableau "liste" qui permet d'ajouter chaque "attribut" que les capteurs délivre
    ArrayList<Object> val = new ArrayList<Object>(); //Le Tableau Val lui contient chaque liste délivrer par les capteurs: si le capteur donne 3 données il y aura 3 listes dans val
    
    public void valeur_random(){
        
        Date aujourdhui = new Date(); //Appelle la classe Date prédéfinie par java
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT); //Permet de sélectionner le format souhaité pour la date
        
        int n; // variable n contient la valeur random généré par le capteur
        
        String v = ""; // la variabel string v, sert à contenir la valeur n dans un format acceptable pour le tableau "liste"
        
        n = (int)(Math.random() * 50); //fabrication de la valeur random
        v = v + n; //conversion en string de la valeur random

        String liste = String.format("%-20s %-20s %-5s %-20s", shortDateFormat.format(aujourdhui), "Capteur n°1", v, "Degré(s)"); // ajout dans liste de tout les élements
        val.add(liste); // ajout de la liste ci-dessus ( une sortes de trame ) dans tableau val
        
        for (Object str:val){ // ce "for" enlève les []
                
            System.out.println(str); // Cette ligne permet d'afficher la Arraylist sans les crochets.
        }
        
    }
}
