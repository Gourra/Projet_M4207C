import java.rmi.RemoteException;
import java.util.ArrayList;

public class TerminalIMPL {
    //Attributs
    int id = 0;
    ArrayList<Data> localbdd = null;

    //constructeur
    public TerminalIMPL(int n){
        id = n; //initialisation du n°id
        this.localbdd = new ArrayList<Data>(); //Initialisation de la local bdd
    }

    public int getId(){return id;}
    public ArrayList<Data> getLocalBdd(){return localbdd;}

    //Afficher les valeurs de la bdd locale
    public void print(){
        for(int i = 0; i < localbdd.size(); i++){
            localbdd.get(i).print();
        }
    }

    //Requète de recupération de bdd du central
    public void getBddData(INTCentral central) throws RemoteException{
        localbdd = central.getBdd();
    }
    
}
