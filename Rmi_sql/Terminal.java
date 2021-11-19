import java.util.ArrayList;

class Terminal{
    //Attributs
    int id;
    ArrayList<Data> localbdd;

    //constructeur
    public Terminal(int n){
        id = n; //initialisation du n°id
        this.localbdd = new ArrayList<Data>(); //Initialisation de la local bdd
    }

    //Méthodes d'acces
    public int getId(){return id;}
    public ArrayList<Data> getLocalBdd(){return localbdd;}

    //###################################
    //          METHODES
    //###################################

    //Afficher les valeurs de la bdd locale
    public void print(){
        for(int i = 0; i < localbdd.size(); i++){
            localbdd.get(i).print();
        }
    }

    //Requète de recupération de bdd du central
    public void getBddData(Central central){
        localbdd = central.getBdd();
    }

    public void getSqlfull(Central central){
        central.getSqlfull();
        localbdd = central.getToReturn();
    }

    public void getSqlfilter(Central central, int ncapt){
        central.getSqlfilter(ncapt);
        localbdd = central.getToReturn();
    }

    public void getSqlreq(Central central, String req){
        central.getSqlreq(req);
        localbdd = central.getToReturn();
    }
}
