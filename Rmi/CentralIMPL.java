import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CentralIMPL extends UnicastRemoteObject implements INTCentral{
    //Attributs
    ArrayList<Data> bdd = null;

    //Constructeur
    CentralIMPL() throws java.rmi.RemoteException{
        this.bdd = new ArrayList<Data>(); //Initiation de la base de donnée
    }

    //méthodes
    public ArrayList<Data> getBdd() throws java.rmi.RemoteException {return bdd;}
    public void addToBdd(Data data) throws java.rmi.RemoteException{
        bdd.add(data);
        System.out.println("[Server-log] : (New data) " + data.printToString());
    }

    public void message(String mess) throws java.rmi.RemoteException {
        System.out.println("[Server] : " + mess);
    }
}
