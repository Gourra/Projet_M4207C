class Data{
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

    //Afficher valeur
    public void print(){
        System.out.println(date + " " + idCapteur + " " + valeur + " " + unite );
    }
}