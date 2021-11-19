import java.io.Serializable;

class Data implements Serializable{
    //Attributs
    public String date;
    public int idCapteur;
    public int valeur;
    public String unite;

    //Constructeur
    public Data(String e_date, int e_idCapteur, int e_valeur, String e_unite){
        date = e_date;
        idCapteur = e_idCapteur;
        valeur = e_valeur;
        unite = e_unite;
    }

    //Méthodes d'accès
    public String getDate(){return date;}
    public int getIdCapteur(){return idCapteur;}
    public int getValeur(){return valeur;}
    public String getUnite(){return unite;}

    //###################################
    //          METHODES
    //###################################
    
    //Afficher valeur
    public void print(){
        System.out.println(date + "  -  capteur n°" + idCapteur + "  -  " + valeur + " " + unite );
    }

    public String print2(){
        String toreturn = date + "  -  capteur n°" + idCapteur + "  -  " + valeur + " " + unite ;
        return toreturn;
    }

    public String printToString(){
        String r =date + "  -  capteur n°" + idCapteur + "  -  " + valeur + " " + unite ;
        return r;
    }
}
