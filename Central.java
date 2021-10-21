import java.util.ArrayList;

class Central{
    //Attributs
    int id;
    ArrayList<Data> bdd;

    //Contructeur
    public Central(int n){
        id = n; //Initiation du n° id
        this.bdd = new ArrayList<Data>(); //Initiation de la base de donnée
    }

    //Méthodes d'accès
    public int getId() {return id;}
    public ArrayList<Data> getBdd() {return bdd;}

    //###################################
    //          METHODES
    //###################################

    //Ajout Data dans bdd
    public void addToBdd(Data data){
        bdd.add(data);
    }

}  