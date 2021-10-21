import java.util.ArrayList;

class Central{
    //Attributs
    int id;
    ArrayList<String> bdd;

    //Contructeur
    public Central(int n){
        id = n; //Initiation du n° id
        this.bdd = new ArrayList<String>(); //Initiation de la base de donnée
    }

    //Méthodes d'accès
    public int getId() {return id;}
    public ArrayList<String> getBdd() {return bdd;}


}