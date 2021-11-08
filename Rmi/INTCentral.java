import java.util.ArrayList;

public interface INTCentral extends java.rmi.Remote { //Interface qui liste toutes les foncntions + héritage du rmi.remote
    ArrayList<Data> getBdd() throws java.rmi.RemoteException; //throws -> peut renvoyer une erreur due au rmi
    void addToBdd(Data data) throws java.rmi.RemoteException;
    void message(String mess) throws java.rmi.RemoteException;
}
