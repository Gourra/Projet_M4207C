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

    //Ajout Data dans bdd
    public void addToBdd(Data data){
        bdd.add(data);
    }

    //Afficher valeur dans bdd
    public void print(){
        for(int i = 0; i < bdd.size(); i++){
            bdd.get(i).print();
        }
    }
}