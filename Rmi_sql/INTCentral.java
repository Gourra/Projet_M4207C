import java.util.ArrayList;

public interface INTCentral extends java.rmi.Remote { //Interface qui liste toutes les foncntions + héritage du rmi.remote
    ArrayList<Data> getBdd() throws java.rmi.RemoteException; //throws -> peut renvoyer une erreur due au rmi
    ArrayList<Data> getToReturn() throws java.rmi.RemoteException;
    void addToBdd(Data data) throws java.rmi.RemoteException;
    void message(String mess) throws java.rmi.RemoteException;
    void addSql(Data data) throws java.rmi.RemoteException;
    void getSqlfull() throws java.rmi.RemoteException;
    void getSqlfilter(int ncapt) throws java.rmi.RemoteException;
    void getSqlreq(String req) throws java.rmi.RemoteException;
}
