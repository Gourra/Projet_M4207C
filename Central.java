import java.util.ArrayList;

class Central{
    //Attributs
    ArrayList<Data> bdd;

    //Contructeur
    public Central(){
        this.bdd = new ArrayList<Data>(); //Initiation de la base de donnée
    }

    //Méthodes d'accès
    public ArrayList<Data> getBdd() {return bdd;}
    public void addToBdd(Data data){
        bdd.add(data);
    }

}  